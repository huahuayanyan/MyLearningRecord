package com.mywork.generator.DataSourceConf;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.mywork.generator.annotation.RoutingDataSource;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

	@SuppressWarnings("rawtypes")
	@Before("@annotation(RoutingDataSource)")
	public void beforeSwitchDS(JoinPoint point) {
		//获得当前访问的Class
		Class<?> className = point.getTarget().getClass();
		//获得访问的方法名
		String methodName = point.getSignature().getName();
		//获得方法的参数类型
		Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
		//默认数据源
		String dataSource = DataSourceContextHolder.DEFAULT_DATA_SOURCE;
		//获得访问的方法对象
		Method method;
		try {
			method = className.getMethod(methodName, argClass);
			//判断方法是否存在数据库切库注解
			if(method.isAnnotationPresent(RoutingDataSource.class)) {	
				RoutingDataSource annotation = method.getAnnotation(RoutingDataSource.class);
				//获取注解中的数据源名
				dataSource = annotation.value();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//数据源切换
		DataSourceContextHolder.setDB(dataSource);
	}
	
	@After("@annotation(RoutingDataSource)")
	public void afterSwitchDS(JoinPoint point) {
		DataSourceContextHolder.clearDB();
	}
}
