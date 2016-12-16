package com.wanghaidong.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.wanghaidong.config.RedisJpaConfig;
import com.wanghaidong.entities.Item;

public class RedisTest {
	public static void main(String[] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisJpaConfig.class);
		//使用RedisConnectionFactory操作Redis
		/*RedisConnectionFactory cf = (RedisConnectionFactory) ctx.getBean("redisCF");
		RedisConnection conn = cf.getConnection();
		conn.set("greeting".getBytes(), "Hello,world!".getBytes());
		byte[] greetingBytes = conn.get("greeting".getBytes());
		String greeting = new String(greetingBytes);
		System.out.println(greeting);*/
		//使用RedisTemplate操作Redis
		RedisTemplate<String, Item> redis = (RedisTemplate<String, Item>) ctx.getBean("redisTemplate");
		Item item = new Item();
		item.setId(11L);
		item.setPrice(51.8);
		item.setProduct("FilmTicket");
		item.setQuantity(2);
		redis.opsForValue().set(item.getProduct(), item);
		Item findItem = redis.opsForValue().get("FilmTicket");
		System.out.println(findItem);
	}
	
	
}
