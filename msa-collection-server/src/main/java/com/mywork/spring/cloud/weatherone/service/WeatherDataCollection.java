package com.mywork.spring.cloud.weatherone.service;

public interface WeatherDataCollection {

	/**
	 * 根据城市Id同步天气数据(即将天气数据保存到本地)
	 * @param cityId
	 */
	void synDataByCityId(String cityId);
}
