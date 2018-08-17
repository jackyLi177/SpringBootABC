package com.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Utils.JWTUtil;
import com.model.Admin;
import com.service.AdminService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liyongjie
 * @date 2018年5月21日
 */
@Service
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private AdminService adminService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyRealm.class);

	/**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}

	/**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = JWTUtil.getUserName(principals.toString());
		Admin admin = adminService.getByName(username);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRole(admin.getRoles());
//		如果有permission		
//		Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//      simpleAuthorizationInfo.addStringPermissions(permission);
		return simpleAuthorizationInfo;
	}

	
	/**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		String token = (String) auth.getCredentials();
		//解密username，用于与数据库对比
		String username = JWTUtil.getUserName(token);
		if(username == null) {
            throw new AuthenticationException("token invalid!!");
        }

		Admin admin = adminService.getByName(username);
		if(admin == null) {
            throw new AuthenticationException("admin dont exit!!");
        }
		
		if(!JWTUtil.parseJWT(token, username, admin.getPassword())) {
            throw new AuthenticationException("username or password error!!");
        }
		
		return new SimpleAuthenticationInfo(token, token, "my_realm");
	}

}
