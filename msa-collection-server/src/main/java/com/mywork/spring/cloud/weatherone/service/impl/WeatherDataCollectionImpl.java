package com.mywork.spring.cloud.weatherone.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mywork.spring.cloud.weatherone.service.WeatherDataCollection;

@Service
public class WeatherDataCollectionImpl implements WeatherDataCollection {

	private static final long TIME_OUT = 1800;
	private static String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public void synDataByCityId(String cityId) {
		String uri = WEATHER_URI+"citykey="+cityId; 
		this.saveWeatherData(uri);
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
