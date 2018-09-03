package com.mywork.dataTransfer.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mywork.dataTransfer.service.TransferDataService;

public class TransferDataJob extends QuartzJobBean{

	@Autowired
	private TransferDataService transferDataService;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		transferDataService.transferDataToNewTable();
	}

}
