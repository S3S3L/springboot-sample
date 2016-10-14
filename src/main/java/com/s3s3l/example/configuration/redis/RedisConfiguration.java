/** 
 * Project Name:spring-boot-empty-project 
 * File Name:RedisConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.redis 
 * Date:Oct 13, 20161:30:53 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/

package com.s3s3l.example.configuration.redis;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>
 * </p>
 * ClassName:RedisConfiguration <br>
 * Date: Oct 13, 2016 1:30:53 PM <br>
 * 
 * @author kehw_zwei
 * @version 1.0.0
 * @since JDK 1.8
 */
@Configurable
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

	@Bean(name = "redisKeyGenerator")
	public KeyGenerator redisKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object param : params) {
					sb.append(param.toString());
				}
				return sb.toString();
			}
		};

	}

	@Bean
	public RedisTemplate<String, String> stringRedisTemplate(
			@Qualifier("stringRedisSerializer") RedisSerializer<String> keySerializer,
			@Qualifier("stringRedisSerializer") RedisSerializer<String> valueSerializer,
			@Qualifier("stringRedisSerializer") RedisSerializer<String> hashKeySerializer,
			@Qualifier("stringRedisSerializer") RedisSerializer<String> hashValueSerializer,
			JedisConnectionFactory connectionFactory) {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setKeySerializer(keySerializer);
		template.setValueSerializer(valueSerializer);
		template.setHashKeySerializer(hashKeySerializer);
		template.setHashValueSerializer(hashValueSerializer);
		template.setConnectionFactory(connectionFactory);
		template.afterPropertiesSet();

		return template;
	}

	@Bean(name = "stringRedisSerializer")
	public StringRedisSerializer stringRedisSerializer() {
		return new StringRedisSerializer();
	}

}
