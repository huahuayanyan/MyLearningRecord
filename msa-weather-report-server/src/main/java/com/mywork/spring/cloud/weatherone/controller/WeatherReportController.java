package com.mywork.spring.cloud.weatherone.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mywork.spring.cloud.weatherone.service.WeatherReportService;
import com.mywork.spring.cloud.weatherone.vo.City;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

	@Autowired
	WeatherReportService weatherReportService;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
	
	@RequestMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) throws Exception {
		
		//TODO 改为由城市数据API微服务
		List<City> cityList = null;
		
		try {
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityName("深圳");
			city.setCityId("101280601");
			cityList.add(city);
		} catch (Exception e) {
			logger.info("Exception!",e);
		}
		
		model.addAttribute("title", "我的天气预报系统");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		
		return new ModelAndView("weather/report","reportModel",model);		//界面名称、模型名称、模型
	}
	
}
