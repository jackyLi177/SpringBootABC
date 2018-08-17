package com.common;

import java.util.HashMap;

import com.exception.WebError;

/**
 * @author liyongjie
 * @date 2018年5月15日
 */
public class Result extends HashMap<String, Object>{
	
	private static final long serialVersionUID = 1L;
	private static final int SUCCESS_CODE = 6000;
	private static final String SUCCESS_INFO = "Success!";
	
	public Result(){
		put("statusCode", SUCCESS_CODE);
		put("info", SUCCESS_INFO);
	}
	
	public Result(Object data){
		put("statusCode", SUCCESS_CODE);
		put("info", SUCCESS_INFO);
		put("data", data);
	}
	
	public Result(int code,String msg,Object data){
		put("statusCode", code);
		put("info",msg);
		put("data",data);
	}
	
	public static Result ok(){
		return new Result();
	}
	
	public static Result ok(Object data){
		return new Result(data);
	}
	
	public static Result error(){
		return new Result(WebError.COMMON_ERROR);
	}
	
	public static Result error(int code){
		Result result = new Result();
		result.put("statusCode", code);
		return result;
	}
	
	public static Result error(int code,String msg){
		Result result = new Result();
		result.put("statusCode", code);
		result.put("info", msg);
		return result;
	}
	
	public static Result error(WebError error){
		Result result = new Result();
		result.put("statusCode", error.statusCode);
		result.put("info", error.info);
		return result;
	}
	
	public static Result error(String msg){
		Result result = new Result();
		result.put("statusCode", WebError.COMMON_ERROR.statusCode);
		result.put("info", msg);
		return result;
	}
	
	public static Result error(String... msg){
		Result result = new Result();
		result.put("statusCode", WebError.COMMON_ERROR.statusCode);
		result.put("info", msg);
		return result;
	}

}
