package com.mywork.spring.cloud.weatherone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfiguration {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		
		//如果什么参数都不设置则默认为6379端口
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPort(6379);
		factory.setHostName("localhost");
		return factory;
		
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
		
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(factory);
		return stringRedisTemplate;
	}
}
