package com.mywork.spring.cloud.weatherone.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.mywork.spring.cloud.weatherone.service.CityDataService;
import com.mywork.spring.cloud.weatherone.util.XmlBuilder;
import com.mywork.spring.cloud.weatherone.vo.City;
import com.mywork.spring.cloud.weatherone.vo.CityList;

@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		
		//读取XML文件
		Resource resource = new ClassPathResource("cityList.xml");
		BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while((line = bf.readLine()) != null) {
			buffer.append(line);
		}
		
		bf.close();
		
		//XML文件内容转化为POJO对象
		CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, buffer.toString());
		return cityList.getCityList();
	}

}
