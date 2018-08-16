package com.mywork.generator.DataSourceConf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理当前进程使用的数据源连接
 */
@Slf4j
public class DataSourceContextHolder {
	
	Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

	public static final String DEFAULT_DATA_SOURCE = DataSources.MASTER_DB;		
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
	
	/**
	 * 设置数据源
	 * @param dbType
	 */
	public static void setDB(String dbType) {
		contextHolder.set(dbType);
	}
	
	/**
	 * 获取数据源名
	 * @return
	 */
	public static String getDB() {
		return contextHolder.get();
	}
	
	public static void clearDB() {
		contextHolder.remove();
	}
}
