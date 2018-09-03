package com.mywork.dataTransfer.dao;

import java.util.List;

import com.mywork.dataTransfer.entity.Emp;

public interface EmpDao {
	
	/**
	 * 批量数据迁移
	 * @return
	 */
	int transferDataToNewTable(Integer id);
	
	List<Emp> empList();
	
	Emp queryEmpById(Integer id);
	
	Integer countSize();
}
