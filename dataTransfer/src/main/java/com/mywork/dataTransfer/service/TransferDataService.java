package com.mywork.dataTransfer.service;

import java.util.List;

import com.mywork.dataTransfer.entity.Emp;

public interface TransferDataService {

	int transferDataToNewTable();
	
	List<Emp> empList();
	
	Emp queryEmpById(Integer id);
	
	Integer countSize();
}
