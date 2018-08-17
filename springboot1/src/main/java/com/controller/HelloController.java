package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.Result;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Learner;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyongjie
 * @date 2018年5月15日
 */
@Slf4j
@RestController("/Spring")
public class HelloController {
	ObjectMapper mapper = new ObjectMapper();

	static Learner l = new Learner("admin","23","man");
	static Map<String,Learner> dataSource = new HashMap<String,Learner>();
	{
		log.info("代码块执行添加Learner------------");
		dataSource.put(l.getName(), l);
	}
	
	@GetMapping("/hello")
	public Result hello(){
		log.info("HelloController.Hello()------------>");
		return Result.ok("Hello SpringBootEvent@!!!!!!!!!!!");
	}
	
	@PostMapping("")
	public Result post(@RequestParam String learner) throws JsonParseException, JsonMappingException, IOException{
		Learner temp = mapper.readValue(learner, Learner.class);
		dataSource.put(temp.getName(), temp);
		return Result.ok(learner);
	}
	
	@GetMapping("")
	public Result get(@RequestParam String name) throws JsonProcessingException{
		Learner lea = dataSource.get(name);
		System.out.println(lea.toString());
		System.out.println(mapper.writeValueAsString(lea));
		return Result.ok(lea);
	}
	
	@PutMapping("")
	public Result put(@RequestParam String learner) throws JsonParseException, JsonMappingException, IOException{
		Learner temp = mapper.readValue(learner, Learner.class);
		dataSource.put(temp.getName(), temp);
		return Result.ok(dataSource.put(temp.getName(), temp));
	}
	
	@DeleteMapping("")
	public Result delete(@RequestParam String name){
		return Result.ok(dataSource.remove(name));
	}

	@GetMapping("/testt")
	public Result testtt(@RequestParam("id") Integer id, HttpServletRequest request){

	    String url = "";
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet h = new HttpGet(url);
	    return Result.ok();
    }
}
