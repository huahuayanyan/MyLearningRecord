package com.mywork.spring.cloud.weatherone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mywork.spring.cloud.weatherone.service.CityDataService;
import com.mywork.spring.cloud.weatherone.service.WeatherDataService;
import com.mywork.spring.cloud.weatherone.service.WeatherReportService;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	WeatherDataService weatherDataService;
	
	@Autowired
	CityDataService cityDataService;
	
	@Autowired
	WeatherReportService weatherReportService;
	
	@RequestMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) throws Exception {
		
		model.addAttribute("title", "我的天气预报系统");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityDataService.listCity());
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		
		return new ModelAndView("weather/report","reportModel",model);		//界面名称、模型名称、模型
	}
	
}
