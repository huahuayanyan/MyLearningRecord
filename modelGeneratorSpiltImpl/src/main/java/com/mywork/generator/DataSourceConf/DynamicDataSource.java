package com.mywork.generator.DataSourceConf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource{
	
	public static final String DEFAULT_DATA_SOURCE = DataSources.MASTER_DB;
	public static final List<String> dataSourceNames = new ArrayList<String>();

	public DynamicDataSource() {}
	
	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceContextHolder.getDB();
	}

}
