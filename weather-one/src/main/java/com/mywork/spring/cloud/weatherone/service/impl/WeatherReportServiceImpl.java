package com.mywork.spring.cloud.weatherone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywork.spring.cloud.weatherone.service.WeatherDataService;
import com.mywork.spring.cloud.weatherone.service.WeatherReportService;
import com.mywork.spring.cloud.weatherone.vo.Weather;
import com.mywork.spring.cloud.weatherone.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
		return weatherResponse.getData();
	}

}
