package com.mywork.spring.cloud.weatherone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywork.spring.cloud.weatherone.service.WeatherReportService;
import com.mywork.spring.cloud.weatherone.vo.Forecast;
import com.mywork.spring.cloud.weatherone.vo.Weather;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Override
	public Weather getDataByCityId(String cityId) {
		
		//TODO
		//改为由天气预报数据API来提供
		//TODO
		Weather data = new Weather();
		data.setAqi("81");
		data.setCity("深圳");
		data.setGanmao("容易感冒！多穿衣");
		data.setWendu("22");
		
		List<Forecast> forecastList = new ArrayList<Forecast>();
		Forecast forecast;
		
		forecast = new Forecast();
		forecast.setDate("6号 星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setHigh("低温 1度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("5号 星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setHigh("低温 1度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("4号 星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setHigh("低温 1度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("3号 星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setHigh("低温 1度");
		forecastList.add(forecast);
		
		forecast = new Forecast();
		forecast.setDate("2号 星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setHigh("低温 1度");
		forecastList.add(forecast);
		
		data.setForecast(forecastList);
		
		return data;
	}

}
