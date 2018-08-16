package com.mywork.spring.cloud.weatherone.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mywork.spring.cloud.weatherone.service.CityDataService;
import com.mywork.spring.cloud.weatherone.service.WeatherDataService;
import com.mywork.spring.cloud.weatherone.vo.City;

public class WeatherDataSynJob extends QuartzJobBean{

	private static final Logger logger = LoggerFactory.getLogger(WeatherDataSynJob.class);

	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Weather DataSyn Job begin");
		List<City> cityList = null;
		
		//获取城市ID列表
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			logger.info("Exception!",e);
		}
		
		//遍历城市ID获取天气
		for(City city : cityList) {
			String cityId = city.getCityId();
			logger.info("WeatherDataSynJob cityId:"+cityId);
			
			weatherDataService.synDataByCityId(cityId);
		}
		logger.info("Weather DataSyn Job end");
	}
}
