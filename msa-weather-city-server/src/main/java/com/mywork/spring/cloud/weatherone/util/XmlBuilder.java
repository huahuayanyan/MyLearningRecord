package com.mywork.spring.cloud.weatherone.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlBuilder {

	/**
	 * 将xml转化为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStr2Object(Class<?> clazz,String xmlStr) throws Exception{
		
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		
		//JAXBContenxt 上下文提供了xml转化为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		
		if(reader != null) {
			reader.close();
		}
		return xmlObject;
	}
}
