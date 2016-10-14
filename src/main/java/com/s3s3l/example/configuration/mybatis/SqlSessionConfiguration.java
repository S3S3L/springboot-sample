/** 
 * Project Name:spring-boot-empty-project 
 * File Name:SqlSessionConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.mybatis 
 * Date:Oct 13, 20161:25:39 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration.mybatis;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * <p>
 * </p> 
 * ClassName:SqlSessionConfiguration <br> 
 * Date:     Oct 13, 2016 1:25:39 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "mybatis")
public class SqlSessionConfiguration {
	private String config;
	private String mapperLocations;
	private String typeAliasesPackage;
	private boolean checkConfigLocation;

	public SqlSessionFactoryBean getSqlSessionFacotyBean(DataSource datasource) throws IOException {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		sessionFactoryBean.setDataSource(datasource);
		sessionFactoryBean.setTypeAliasesPackage(this.getTypeAliasesPackage());
		sessionFactoryBean.setConfigLocation(pathResolver.getResource(this.getConfig()));
		sessionFactoryBean.setMapperLocations(pathResolver.getResources(this.getMapperLocations()));

		return sessionFactoryBean;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}

	public String getTypeAliasesPackage() {
		return typeAliasesPackage;
	}

	public void setTypeAliasesPackage(String typeAliasesPackage) {
		this.typeAliasesPackage = typeAliasesPackage;
	}

	public boolean isCheckConfigLocation() {
		return checkConfigLocation;
	}

	public void setCheckConfigLocation(boolean checkConfigLocation) {
		this.checkConfigLocation = checkConfigLocation;
	}

}
  