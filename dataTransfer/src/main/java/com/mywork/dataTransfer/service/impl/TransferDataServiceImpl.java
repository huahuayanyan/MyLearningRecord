package com.mywork.dataTransfer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywork.dataTransfer.dao.EmpDao;
import com.mywork.dataTransfer.entity.Emp;
import com.mywork.dataTransfer.service.TransferDataService;

@Service
public class TransferDataServiceImpl implements TransferDataService{

	@Autowired
	private EmpDao empDao;
	
	
	@Override
	@Transactional
	public int transferDataToNewTable() {
		return empDao.transferDataToNewTable();
	}


	@Override
	public List<Emp> empList() {
		return empDao.empList();
	}
	
	@Override
	public Emp queryEmpById(Integer id) {
		return empDao.queryEmpById(id);
	}


	@Override
	public Integer countSize() {
		Long start = System.currentTimeMillis();
		int size = empDao.countSize();
		Long end = System.currentTimeMillis();
		System.out.println("queryTime:" + (end - start));
		return size;
	}
}
