/** 
 * Project Name:spring-boot-empty-project 
 * File Name:Application.java 
 * Package Name:com.s3s3l.example.app 
 * Date:Oct 12, 20166:54:52 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/

package com.s3s3l.example.app;

import java.io.File;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.s3s3l.utils.file.FileUtil;

/**
 * <p>
 * </p>
 * ClassName:Application <br>
 * Date: Oct 12, 2016 6:54:52 PM <br>
 * 
 * @author kehw_zwei
 * @version 1.0.0
 * @since JDK 1.8
 */
@EnableAutoConfiguration
@ComponentScan({ "com.s3s3l" })
@SpringBootApplication
public class Application extends ContextIdApplicationContextInitializer {

	private static final String[] LOG4J_CONFIG = new String[] { "file:config/log4j/log4j2.yml",
			"file:conf/log4j/log4j2.yml", "file:log4j2.yml", "classpath:config/log4j/log4j2.yml",
			"classpath:conf/log4j/log4j2.yml", "classpath:log4j2.yml" };

	public static void main(String[] args) {
		configureLog4j();
		
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 
	 * 配置log4j2
	 * 
	 * @since JDK 1.8
	 */
	private static void configureLog4j() {
		Properties props = System.getProperties();
		props.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		File configFile = FileUtil.getFirstExistFile(LOG4J_CONFIG);
		if (configFile != null) {
			props.setProperty("log4j.configurationFile", configFile.getAbsolutePath());
		}
	}
}
