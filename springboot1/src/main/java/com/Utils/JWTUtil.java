package com.Utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * JWTUtils
 * 
 * @author liyongjie
 * @date 2018年5月21日
 */
public class JWTUtil {
	
	//过期时间
	private static final long EXPIRE_TIME = 30*60*1000;
	
	//生成token
	public static String createJWT(String username,String secret){
		try {
			return JWT.create()
					  .withClaim("username", username) //附带username信息
					  .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRE_TIME))
					  .sign(Algorithm.HMAC256(secret));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	//解析token
	public static boolean parseJWT(String token,String username,String secret){
		try {
			DecodedJWT dJWT = 
				JWT.require(Algorithm.HMAC256(secret))
			   .withClaim("username", username)
			   .build()
			   .verify(token);
			return true;
		} catch (JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//从token总获取附带信息(username)
	public static String getUserName(String token){
		return JWT.decode(token).getClaim("username").asString();
	}
	
}
