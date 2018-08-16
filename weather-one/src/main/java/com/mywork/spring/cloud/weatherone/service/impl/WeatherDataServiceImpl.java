package com.mywork.spring.cloud.weatherone.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	
	private static final long TIME_OUT = 1800;
	private static String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	
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
	
	@Override
	public void synDataByCityId(String cityId) {
		String uri = WEATHER_URI+"citykey="+cityId; 
		this.saveWeatherData(uri);
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
		}else{	//缓存中不存在数据
			ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
			
			if(respString.getStatusCodeValue() == 200) {
				logger.info("get data from other API");
				strBody = respString.getBody();		//获取Json类型的字符串
			}
			ops.set(key, strBody);		//数据放入缓存
		}
		
		try {
			resp = mapper.readValue(strBody, WeatherResponse.class);	//Json字符串转化为对象
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("error !",e);
		} 
		return resp;
	}

	/**
	 * 保存天气数据将数据放入缓存中
	 * @param uri
	 */
	private void saveWeatherData(String uri) {
		
		String key = uri;
		String strBody = null;
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		
		//调用服务接口来获取天气数据并写入缓存(存在则覆盖不存在则取出)
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		if(respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();		//获取Json类型的字符串
		}
		ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
	}

}
