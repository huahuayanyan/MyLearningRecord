package com.mywork.generator.plugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class PaginationPlugin extends PluginAdapter{

	public static final String CLASS_NAME = "com.mywork.one.common.beans.Page";
	
	public static final String ATTR_NAME = "page";
	
	public boolean validate(List<String> arg0) {
		return true;
	}
	
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		addLimit(topLevelClass,introspectedTable);
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
	
	/**
	 * ��ҳ�����ڵ���뵽SelectByExample������
	 */
	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "page != null"));
		isNotNullElement.addElement(new TextElement(" limit ${page.pageIndex}, ${page.pageSize}"));
		element.addElement(isNotNullElement);
		return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
	}
	
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "page != null"));
		isNotNullElement.addElement(new TextElement(" limit ${page.pageIndex}, ${page.pageSize}"));
		element.addElement(isNotNullElement);
		return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
	}
	
	/**
	 * ��sample���������name��get��set����
	 * @param topLevelClass
	 * @param introspectedTable
	 */
	private void addLimit(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		
		char c = ATTR_NAME.charAt(0);
		String tempName = Character.toUpperCase(c)+ATTR_NAME.substring(1);
		
		FullyQualifiedJavaType fullyQualifiedJavaType = new FullyQualifiedJavaType(CLASS_NAME);
		
		//�������name
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(fullyQualifiedJavaType);
		field.setName(ATTR_NAME);
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		
		//���set����
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + tempName);
		method.addParameter(new Parameter(fullyQualifiedJavaType, ATTR_NAME));
		method.addBodyLine("this." + ATTR_NAME + " = " + ATTR_NAME + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		
		//���get����
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName(" get" + tempName);
		method.setReturnType(fullyQualifiedJavaType);
		method.addBodyLine("return " + ATTR_NAME + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		
	}
}
