package com.mywork.generator.DataSourceConf;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.mywork.generator.dao"})
public class MyBatisConfig {

	@Autowired
	@Qualifier(DataSources.MASTER_DB)
	private DataSource masterDB;
	
	@Autowired
	@Qualifier(DataSources.SLAVE_DB)
	private DataSource slaveDB;
	
	/**
	 * 动态数据源
	 */
	@Bean(name = "dynamicDataSource")
	public DataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setDefaultTargetDataSource(masterDB);		
		Map<Object,Object> targetDataSources = new HashMap<Object,Object>();
		targetDataSources.put("masterDB", masterDB);
		targetDataSources.put("slaveDB", slaveDB);
		dynamicDataSource.setTargetDataSources(targetDataSources);
		return dynamicDataSource;
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis")
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dynamicDataSource());
		return sqlSessionFactoryBean;
	} 
}
