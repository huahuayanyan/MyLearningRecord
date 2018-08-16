package com.mywork.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mywork.generator.DataSourceConf.DataSources;

/**
 * 自定义切库注解
 * Retention 指定注解存在的范围，具体由RetentionPolicy指定
 * Target 注解作用的目标，具体由ElementType指定
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
	ElementType.METHOD
})
public @interface RoutingDataSource {
	String value() default DataSources.MASTER_DB;
}
