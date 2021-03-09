package com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.redis.RedisUtils;

@SpringBootTest
public class RedisTest {
	
	@Resource
	private RedisUtils redisUtils;
 
	/**
	 * 插入缓存数据
	 */
	@Test
	public void set() {
		redisUtils.set("redis_key", "redis_vale");
	}
	
	/**
	 * 读取缓存数据
	 */
	@Test
	public void get() {
		String value = redisUtils.get("1");
		System.out.println(value);
	}
}
