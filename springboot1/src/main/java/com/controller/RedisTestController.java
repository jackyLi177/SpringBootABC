package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.Result;
import com.model.Admin;
import com.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
	
	@Autowired
	private RedisService redisService;
	
	@GetMapping("/init")
	public Result InitRedis(){
		Admin admin = new Admin();
		admin.setId(1);
		admin.setName("Tom");
		redisService.set("1", "111");
		redisService.set("admin", admin);
		return Result.ok();
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam String key,@RequestParam Object data){
		redisService.set(key, data);
		return Result.ok();
	}
	
	@PostMapping("/addExp")
	public Result addExp(@RequestParam String key,@RequestParam Object data,@RequestParam long time){
		redisService.set(key, data, time);
		return Result.ok();
	}
	
	@DeleteMapping("/del/{key}")
	public Result del(@PathVariable String key){
		return Result.ok(redisService.remove(key));
	}
	
	@DeleteMapping("/delAll/{keys}")
	public Result delAll(@PathVariable String... keys){
		redisService.delAll(keys);
		return Result.ok();
	}
}
