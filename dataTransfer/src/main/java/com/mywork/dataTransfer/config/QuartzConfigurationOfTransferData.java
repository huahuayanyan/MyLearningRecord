package com.mywork.dataTransfer.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;

import com.mywork.dataTransfer.job.TransferDataJob;

public class QuartzConfigurationOfTransferData {
	
	//更新频率
	private static final int TIME_FREQUENCY = 10;
	
	//JobDetail
	@Bean
	public JobDetail dataTransferJobDetail() {
		return JobBuilder.newJob(TransferDataJob.class).withIdentity("dataTransferJobDetail")
				.storeDurably().build();
	}
	
	//Trigger
	@Bean
	public Trigger dataTransferTrigger() {
		
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME_FREQUENCY).repeatForever();
		return TriggerBuilder.newTrigger().forJob(dataTransferJobDetail())
				.withIdentity("dataTransferTrigger").withSchedule(schedBuilder).build();
	}
}
