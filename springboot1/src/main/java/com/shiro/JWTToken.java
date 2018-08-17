package com.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author liyongjie
 * @date 2018年5月21日
 */
public class JWTToken implements AuthenticationToken {
	
	private String token;
	
	public JWTToken(String token){
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

}
