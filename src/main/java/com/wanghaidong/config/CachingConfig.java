package com.wanghaidong.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * 
* @ClassName: CachingConfig 
* @Description: ʹ��redis���� 
* @author wanghaidong 
* @date 2016��12��16�� ����4:06:10
 */
@Configuration
@EnableCaching
public class CachingConfig {
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate){
		return new RedisCacheManager(redisTemplate);
	}
}
