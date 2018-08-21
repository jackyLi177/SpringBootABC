package com.jacky.jwtdemo.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jacky.jwtdemo.bean.MyToken;
import com.jacky.jwtdemo.bean.TokenResp;
import com.jacky.jwtdemo.bean.User;
import com.jacky.jwtdemo.dao.TokenDao;
import com.jacky.jwtdemo.dao.UserDao;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
@RestController
public class TokenController {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    @GetMapping("/token")
    public TokenResp token(@RequestParam("username") String username,@RequestParam("password") String password){
        TokenResp resp = new TokenResp();

        if (username == null || username.trim().equals("")){
            resp.setInfo("username is not found!");
            resp.setFlag(false);
        }else if(password == null || password.trim().equals("")){
            resp.setFlag(false);
            resp.setInfo("password is not found!");
        }else {
            //根据appId查询用户实体
            Optional<User> userOptional = userDao.findOne(new Specification<User>() {
                @Override
                public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
                    return null;
                }
            });

            User user = userOptional.get();
            if (user == null){
                resp.setFlag(false);
                resp.setInfo("username: "+username+"  is not found!");
            }else if (!new String(user.getPassword()).equals(password.replace(" ","+"))){
                resp.setFlag(false);
                resp.setInfo("password is not effective!");
            }else {
                //检测数据库是否存在该appId的token值
                Optional<MyToken> myTokenOptional = tokenDao.findOne(new Specification<MyToken>() {
                    @Override
                    public Predicate toPredicate(Root<MyToken> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                        criteriaQuery.where(criteriaBuilder.equal(root.get("username"),username));
                        return null;
                    }
                });

                String tokenstr = null;
                MyToken myToken = null;
                //tokenDBEntity == null -> 生成newToken -> 保存数据库 -> 写入内存 -> 返回newToken
                if (!myTokenOptional.isPresent()){
                    tokenstr = createToken(username,password);
                    myToken = new MyToken();
                    myToken.setCreateTime(String.valueOf(System.currentTimeMillis()));
                    myToken.setToken(tokenstr);
                    myToken.setUsername(user.getUsername());
                    tokenDao.save(myToken);
                }
                //tokenDBEntity != null -> 验证是否超时 ->
                //不超时 -> 直接返回dbToken
                //超时 -> 生成newToken -> 更新dbToken -> 更新内存Token -> 返回newToken
                else {
                    myToken = myTokenOptional.get();
                    //判断数据库中token是否过期，如果没有过期不需要更新直接返回数据库中的token即可
                    //数据库中生成时间
                    long dbCreateTime = Long.valueOf(myToken.getCreateTime());
                    long currentTime = System.currentTimeMillis();
                    long second = TimeUnit.MILLISECONDS.toSeconds(currentTime - dbCreateTime);
                    if (second > 0 && second < 3*60*1000){
                        tokenstr = new String(myToken.getToken());
                    }else {
                        //生成newToken
                        tokenstr = createToken(username,password);
                        //更新token
                        myToken.setToken(tokenstr);
                        //更新生成时间
                        myToken.setCreateTime(String.valueOf(System.currentTimeMillis()));
                        //执行更新
                        tokenDao.save(myToken);
                    }
                }
                resp.setToken(tokenstr);
            }
        }
        return resp;
    }

    public String createToken(String username,String password){
        Date time = new Date();
        Date expiration = new Date(time.getTime() + 3*60*1000);
        try {
            return JWT.create()
                    .withClaim("username",username)
                    .withIssuedAt(time)
                    .withExpiresAt(expiration)
                    .sign(Algorithm.HMAC256(password));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("token init failed！");
        }
    }

}
