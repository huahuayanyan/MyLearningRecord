package com.mywork.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.dataTransfer.entity.Emp;
import com.mywork.dataTransfer.service.TransferDataService;

@RestController
@RequestMapping("/transferData")
public class EmpController {

	@Autowired
	private TransferDataService transferDataService;
	
	@RequestMapping(value = "/queryEmpById", method = RequestMethod.GET)
	public Emp empList(Integer id) {
		return transferDataService.queryEmpById(id);
	}
	
	@RequestMapping(value = "/empSize", method = RequestMethod.GET)
	public int empSize() {
		return transferDataService.countSize();
	}
	
	@RequestMapping(value = "/transferData" , method = RequestMethod.GET)
	public int copyEmpInfoToNewTable(Integer id) {
		return transferDataService.transferDataToNewTable(id); 
	}
}
