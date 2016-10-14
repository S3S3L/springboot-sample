/** 
 * Project Name:spring-boot-empty-project 
 * File Name:CacheConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.cache 
 * Date:Oct 13, 20161:22:28 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration.cache;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>
 * </p> 
 * ClassName:CacheConfiguration <br> 
 * Date:     Oct 13, 2016 1:22:28 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
public class CacheConfiguration {

	@Bean
	public CacheManager cacheManager(RedisCacheManagerConfiguration configuration,
			@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(configuration.getDefaultExpiration());
		cacheManager.setUsePrefix(configuration.isUsePrefix());
		cacheManager.setLoadRemoteCachesOnStartup(configuration.isLoadRemoteCachesOnStartup());
		return cacheManager;
	}

}
  