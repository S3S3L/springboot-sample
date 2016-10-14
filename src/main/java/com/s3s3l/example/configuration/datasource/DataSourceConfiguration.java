/** 
 * Project Name:spring-boot-empty-project 
 * File Name:DataSourceConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.datasource 
 * Date:Oct 13, 20161:38:08 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/

package com.s3s3l.example.configuration.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * <p>
 * </p>
 * ClassName:DataSourceConfiguration <br>
 * Date: Oct 13, 2016 1:38:08 PM <br>
 * 
 * @author kehw_zwei
 * @version 1.0.0
 * @since JDK 1.8
 */
@Configuration
public class DataSourceConfiguration {

	@Bean
	public javax.sql.DataSource dataSource(ConnectionPoolConfiguration datasourceConfiguration) throws Exception {
		DataSource datasource = new DataSource();
		if (datasourceConfiguration.isCryptographic()) {
			// TODO decrypt password
		}
		datasource.setPoolProperties(datasourceConfiguration);
		return datasource;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(javax.sql.DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}
}
