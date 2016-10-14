/** 
 * Project Name:spring-boot-empty-project 
 * File Name:ConnectionPoolConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.datasource 
 * Date:Oct 13, 20161:24:14 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration.datasource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p> 
 * ClassName:ConnectionPoolConfiguration <br> 
 * Date:     Oct 13, 2016 1:24:14 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "datasource")
public class ConnectionPoolConfiguration extends PoolProperties {

	/** 
	 * @since JDK 1.8
	 */  
	private static final long serialVersionUID = 6725692449166203787L;
	private boolean cryptographic;

	public boolean isCryptographic() {
		return cryptographic;
	}

	public void setCryptographic(boolean cryptographic) {
		this.cryptographic = cryptographic;
	}

}
  