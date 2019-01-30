package com.jacky.mybatis_plus_demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jacky.mybatis_plus_demo.entity.User;
import com.jacky.mybatis_plus_demo.dao.UserMapper;
import com.jacky.mybatis_plus_demo.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyongjie
 * @since 2019-01-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    static final String SALT = "SALT";

    public String getMD5Pwd(String plainPass){
        SimpleHash hash = new SimpleHash("md5",plainPass,SALT,1);
        return hash.toString();
    }

    public boolean verifyLogin(String name,String password){

        User u = new User();
        u.setName(name);
        u.setPassword(getMD5Pwd(password));
        User user = this.baseMapper.selectOne(u);
        if (user == null){
            return false;
        }
        return true;
    }

}
