package com.wanghaidong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.wanghaidong.entities.Item;

@Configuration
public class RedisJpaConfig {
	@Bean
	public RedisConnectionFactory redisCF(){
		JedisConnectionFactory cf = new JedisConnectionFactory();
		cf.setHostName("172.19.5.228");
		return cf;
	}
	@Bean
	public RedisTemplate<String, Item> redisTemplate(RedisConnectionFactory cf){
		RedisTemplate<String, Item> redis = new RedisTemplate<String, Item>();
		redis.setConnectionFactory(cf);
		return redis;
	}
}
