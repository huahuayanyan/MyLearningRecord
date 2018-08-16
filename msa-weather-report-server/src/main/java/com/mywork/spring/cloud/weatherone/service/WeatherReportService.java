package com.mywork.spring.cloud.weatherone.service;

import com.mywork.spring.cloud.weatherone.vo.Weather;

public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	public Weather getDataByCityId(String cityId);
}
