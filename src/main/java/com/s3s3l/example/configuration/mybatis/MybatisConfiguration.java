/** 
 * Project Name:spring-boot-empty-project 
 * File Name:MybatisConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.mybatis 
 * Date:Oct 13, 20161:41:36 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p> 
 * ClassName:MybatisConfiguration <br> 
 * Date:     Oct 13, 2016 1:41:36 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
@MapperScan(basePackages = "com.easybike.aaa.dao")
public class MybatisConfiguration {

}
  