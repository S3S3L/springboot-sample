/** 
 * Project Name:spring-boot-empty-project 
 * File Name:SqlSessionFactoryConfiguration.java 
 * Package Name:com.s3s3l.example.configuration.mybatis 
 * Date:Oct 13, 20161:27:33 PM 
 * Copyright (c) 2016, kehw.zwei@gmail.com All Rights Reserved. 
 * 
*/  
  
package com.s3s3l.example.configuration.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p> 
 * ClassName:SqlSessionFactoryConfiguration <br> 
 * Date:     Oct 13, 2016 1:27:33 PM <br>
 *  
 * @author   kehw_zwei 
 * @version  1.0.0
 * @since    JDK 1.8
 */
@Configuration
public class SqlSessionFactoryConfiguration {

    @Bean
    public SqlSessionFactory bdSqlSessionFactory(DataSource dataSource, SqlSessionConfiguration config)
            throws Exception {
        return config.getSqlSessionFacotyBean(dataSource).getObject();
    }
}
  