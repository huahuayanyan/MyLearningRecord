package com.mywork.spring.cloud.weatherone.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "d1")
	private String cityId;		//城市ID
	
	@XmlAttribute(name = "d2")
	private String cityName;	//城市名称
	
	@XmlAttribute(name = "d3")
	private String cityCode;	//城市编码
	
	@XmlAttribute(name = "d4")
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
