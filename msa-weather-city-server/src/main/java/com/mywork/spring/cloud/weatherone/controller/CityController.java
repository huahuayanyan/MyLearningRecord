package com.mywork.spring.cloud.weatherone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.spring.cloud.weatherone.service.CityDataService;
import com.mywork.spring.cloud.weatherone.vo.City;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	CityDataService cityDataService;
	
	@RequestMapping
	public List<City> hello() throws Exception {
		return cityDataService.listCity();
	}
}
