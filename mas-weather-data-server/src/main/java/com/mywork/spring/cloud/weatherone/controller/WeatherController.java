package com.mywork.spring.cloud.weatherone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.spring.cloud.weatherone.service.WeatherDataService;
import com.mywork.spring.cloud.weatherone.vo.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	WeatherDataService weatherDataService;
	
	@RequestMapping("/cityId/{cityId}")
	public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@RequestMapping("/cityName/{cityName}")
	public WeatherResponse getDataByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}
}
