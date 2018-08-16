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
    	//创建配置解析器,用于对配置文件generatorConfig.xml的解析
    	ConfigurationParser cp = new ConfigurationParser(warnings);
    	//调用配置解析器创建配置对象
    	Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
    	//创建一个ShellCallback对象，shellcallback接口主要用来处理文件的创建与合并,默认的shellback是不支持合并的
    	DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
    	MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,shellCallback,warnings);
    	myBatisGenerator.generate(null);
    	for(String string : warnings) {
    		System.out.println(string);
    	}
    }
}
