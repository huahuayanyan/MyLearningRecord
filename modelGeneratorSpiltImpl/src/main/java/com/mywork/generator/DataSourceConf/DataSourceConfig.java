package com.mywork.generator.DataSourceConf;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {

	//destroyMethod = close ,当数据库连接不再使用的时候将连接重新放回到数据库连接池中，以便下次使用调用
	@Bean(destroyMethod = "close", name = DataSources.MASTER_DB)
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
	
	@Bean(destroyMethod = "close", name = DataSources.SLAVE_DB)
	@ConfigurationProperties(prefix = "spring.datasourceSlave")
	public DataSource dataSourceSlave() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
}
