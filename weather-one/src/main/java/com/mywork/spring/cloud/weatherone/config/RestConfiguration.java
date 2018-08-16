package com.mywork.spring.cloud.weatherone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration
 * @author 15451
 *
 */
@Configuration
public class RestConfiguration {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Bean
	public RestTemplate restTemplate() {
		return restTemplateBuilder.build();
	}
}
