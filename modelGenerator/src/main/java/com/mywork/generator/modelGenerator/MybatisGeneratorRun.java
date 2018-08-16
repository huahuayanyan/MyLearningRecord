package com.mywork.generator.modelGenerator;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class MybatisGeneratorRun 
{
    public static void main(String[] args) throws Exception{
    	List<String> warnings = new ArrayList<String>();
    	boolean overwrite = true;
    	//�������ý�����,���ڶ������ļ�generatorConfig.xml�Ľ���
    	ConfigurationParser cp = new ConfigurationParser(warnings);
    	//�������ý������������ö���
    	Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
    	//����һ��ShellCallback����shellcallback�ӿ���Ҫ���������ļ��Ĵ�����ϲ�,Ĭ�ϵ�shellback�ǲ�֧�ֺϲ���
    	DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
    	MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,shellCallback,warnings);
    	myBatisGenerator.generate(null);
    	for(String string : warnings) {
    		System.out.println(string);
    	}
    }
}
