/** 
 * Project Name:spring-boot-empty-project 
 * File Name:RedisCacheManagerConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.cache 
 * Date:Oct 13, 20161:21:19 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/

package com.s3s3l.example.configuration.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 * ClassName:RedisCacheManagerConfiguration <br>
 * Date: Oct 13, 2016 1:21:19 PM <br>
 * 
 * @author kehw_zwei
 * @version 1.0.0
 * @since JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "cache.redis")
public class RedisCacheManagerConfiguration {
	
	private long defaultExpiration = 0;
	private boolean loadRemoteCachesOnStartup = false;
	private boolean usePrefix = false;

	public long getDefaultExpiration() {
		return defaultExpiration;
	}

	public void setDefaultExpiration(long defaultExpiration) {
		this.defaultExpiration = defaultExpiration;
	}

	public boolean isLoadRemoteCachesOnStartup() {
		return loadRemoteCachesOnStartup;
	}

	public void setLoadRemoteCachesOnStartup(boolean loadRemoteCachesOnStartup) {
		this.loadRemoteCachesOnStartup = loadRemoteCachesOnStartup;
	}

	public boolean isUsePrefix() {
		return usePrefix;
	}

	public void setUsePrefix(boolean usePrefix) {
		this.usePrefix = usePrefix;
	}
}
