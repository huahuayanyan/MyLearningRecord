package com.mywork.spring.cloud.weatherone.service;

import java.util.List;

import com.mywork.spring.cloud.weatherone.vo.City;

public interface CityDataService {

	/**
	 * 获取城市列表
	 */
	List<City> listCity() throws Exception;
}
