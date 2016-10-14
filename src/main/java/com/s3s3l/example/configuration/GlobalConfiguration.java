/** 
 * Project Name:spring-boot-empty-project 
 * File Name:GlobalConfiguration.java 
 * Package Name:com.s3s3l.example.configuration 
 * Date:Oct 13, 20161:16:38 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p> 
 * ClassName:GlobalConfiguration <br> 
 * Date:     Oct 13, 2016 1:16:38 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "global")
public class GlobalConfiguration {

}
  