package com.mywork.generator.dao;

import com.mywork.generator.entity.User;

public interface SysUserMapper {

	User selectByPrimaryKey(Long id);
	
}
