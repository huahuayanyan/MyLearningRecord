package com.mywork.spring.cloud.weatherone.vo;

import java.io.Serializable;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cityId;		//城市ID
	
	private String cityName;	//城市名称
	
	private String cityCode;	//城市编码
	
	private String province;	//省份
	
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
