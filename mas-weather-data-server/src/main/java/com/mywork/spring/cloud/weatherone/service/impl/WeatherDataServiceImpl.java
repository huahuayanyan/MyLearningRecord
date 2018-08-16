package com.mywork.spring.cloud.weatherone.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywork.spring.cloud.weatherone.service.WeatherDataService;
import com.mywork.spring.cloud.weatherone.vo.WeatherResponse;

/**
 * 天气预报具体实现
 * @author 15451
 *
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	
	private static String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		
		String uri = WEATHER_URI+"citykey="+cityId;
		return getResp(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_URI+"city="+cityName;
		return getResp(uri);
	}
	
	/**
	 * 根据请求地址获取请求数据
	 * @param uri
	 * @return
	 */
	private WeatherResponse getResp(String uri) {
		
		String key = uri;
		WeatherResponse resp = null;
		ObjectMapper mapper = new ObjectMapper();
		String strBody = null;
		
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		if(stringRedisTemplate.hasKey(key)) {		//缓存中存在数据
			logger.info("get data from redis");
			strBody = ops.get(key);
		}else{	
			logger.info("redis hasn't data");
			//缓存中没有抛出异常
			throw new RuntimeException();
		}
		
		try {
			resp = mapper.readValue(strBody, WeatherResponse.class);	//Json字符串转化为对象
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("error !",e);
		} 
		return resp;
	}

}
