package com.mywork.generator.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mywork.generator.DataSourceConf.DataSources;
import com.mywork.generator.annotation.RoutingDataSource;
import com.mywork.generator.dao.SysUserMapper;
import com.mywork.generator.entity.User;

@Service
public class DataSourceRoutingService {

	@Resource
	private SysUserMapper sysUserMapper;
	
	@RoutingDataSource(DataSources.MASTER_DB)
	public User test1(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
	
	@RoutingDataSource(DataSources.SLAVE_DB)
	public User test2(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
}
