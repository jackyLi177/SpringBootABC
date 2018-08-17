package com.service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author liyongjie
 * @date 2018年5月17日
 */
/**
 * @author liyongjie
 * @date 2018年5月17日
 */
@Service
@Cacheable(key = "annotation")
public class RedisService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;


	public boolean set(String key,Object data){
		ValueOperations<String, Object> op = redisTemplate.opsForValue();
		op.set(key, data);
		//redisTemplate.opsForValue().set(key, data);
		return true;
	}

	public boolean set(String key,Object data,long time){
		redisTemplate.opsForValue().set(key, data, time, TimeUnit.SECONDS);
		return true;
	}

	public boolean remove(String key){
		if(redisTemplate.hasKey(key)){
			redisTemplate.delete(key);
		}
		return true;
	}
	
	public boolean removeAll(String pattern){
		Set<String> keys = redisTemplate.keys(pattern);
		if(!keys.isEmpty()){
			redisTemplate.delete(keys);
		}
		return true;
	} 
	
	public void delAll(String... keys){
		for(String s : keys){
			remove(s);
		}
	}
}
