package com.mywork.generator.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;

public class MyCommentGenerator implements CommentGenerator{

	private Properties properties;
	private Properties systemPro;
	private boolean suppressDate;
	private boolean suppressAllComments;
	private String currentDataStr;
	
	
	public MyCommentGenerator() {
		super();
		properties = new Properties();
		systemPro = System.getProperties();
		System.out.println(systemPro.getProperty("user.name"));
		suppressDate = false;
		suppressAllComments = false;
		currentDataStr = (new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	
	/**
	 * 添加类注释
	 */
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if(suppressAllComments) {
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(introspectedTable.getRemarks());
		sb.append(" ");
		sb.append(getDateString());
		innerClass.addJavaDocLine(sb.toString());
		innerClass.addJavaDocLine(" */");
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if(suppressAllComments) {
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		innerClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerClass.addJavaDocLine(sb.toString());
		
		sb.setLength(0);
		sb.append(" * @author ");
		sb.append(systemPro.getProperty("user.name"));
		sb.append(" ");
		sb.append(currentDataStr);
		innerClass.addJavaDocLine(" */");
	}

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
		suppressAllComments = "true".equals(
				properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
		suppressDate = "true".equals(
				PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE);
	}

	/**
	 * 属性注释
	 */
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) {
		if(suppressAllComments) {
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		field.addJavaDocLine(sb.toString());
		field.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
 		if(suppressAllComments) {
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		field.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		field.addJavaDocLine(sb.toString());
		field.addJavaDocLine(" */");
		
	}

	/**
	 * getter方法注释
	 */
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if(suppressAllComments) {
			return;
		}
		
		method.addJavaDocLine("/**");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		
		sb.setLength(0);
		sb.append(" *@return ");
		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		method.addJavaDocLine(" */");
	}

	/**
	 * model类文件注释
	 */
	public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		if(suppressAllComments) {
			return;
		}
		
		StringBuffer sb = new StringBuffer();
		topLevelClass.addJavaDocLine("/**");
		sb.append(" * ");
		sb.append(introspectedTable.getFullyQualifiedTable());
		topLevelClass.addJavaDocLine(sb.toString());
		
		sb.setLength(0);
		sb.append(" * ");
		sb.append(introspectedTable.getRemarks());
		topLevelClass.addJavaDocLine(sb.toString());
		topLevelClass.addJavaDocLine(" */");
	}

	/**
	 * setter方法注释
	 */
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if(suppressAllComments) {
			return;
		}
		
		method.addJavaDocLine("/**");
		StringBuffer sb = new StringBuffer();
		sb.append(" * ");
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		
		Parameter parameter = method.getParameters().get(0);
		sb.setLength(0);
		sb.append(" * @param ");
		sb.append(parameter.getName());
		sb.append(introspectedColumn.getRemarks());
		method.addJavaDocLine(sb.toString());
		method.addJavaDocLine(" */");
	}
	
	protected String getDateString() {
		String result = null;
		if(!suppressDate) {
			result = currentDataStr;
		}
		return result;
				
	}
	
	public void addRootComment(XmlElement arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * java包上的注释
	 */
	public void addJavaFileComment(CompilationUnit arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void addGeneralMethodAnnotation(Method arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}

	public void addGeneralMethodAnnotation(Method arg0, IntrospectedTable arg1, IntrospectedColumn arg2,
			Set<FullyQualifiedJavaType> arg3) {
		// TODO Auto-generated method stub
		
	}

	public void addGeneralMethodComment(Method arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addEnumComment(InnerEnum arg0, IntrospectedTable arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addFieldAnnotation(Field arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}

	public void addFieldAnnotation(Field arg0, IntrospectedTable arg1, IntrospectedColumn arg2,
			Set<FullyQualifiedJavaType> arg3) {
		// TODO Auto-generated method stub
		
	}
	
	public void addComment(XmlElement arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void addClassAnnotation(InnerClass arg0, IntrospectedTable arg1, Set<FullyQualifiedJavaType> arg2) {
		// TODO Auto-generated method stub
		
	}
}
