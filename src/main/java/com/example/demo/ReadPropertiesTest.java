package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ReadPropertiesTest {
	public static void main(String[] args) throws Exception, IOException {
		//法1
		/*Properties pro = new Properties();
		ClassLoader classLoader = ReadPropertiesTest.class.getClassLoader();
		URL resource = classLoader.getResource("quartz.properties");
		pro.load(new FileReader(resource.getPath()));
		System.out.println(pro.getProperty("org.quartz.jobStore.misfireThreshold"));*/
		
		//法2
		/*Properties pro = new Properties();
		Resource resource = new ClassPathResource("quartz.properties");
		InputStream inputStream = resource.getInputStream();
		pro.load(inputStream);
		System.out.println(pro.getProperty("org.quartz.jobStore.misfireThreshold"));*/
		
		//法3
		//Properties pro = PropertiesLoaderUtils.loadAllProperties("quartz.properties");
		//System.out.println(pro.getProperty("org.quartz.jobStore.misfireThreshold"));
		
		//法4  失败 Can't find bundle for base name quartz.properties, locale zh_CN
		//ResourceBundle resourceBundle = ResourceBundle.getBundle("quartz");
		//System.out.println( resourceBundle.getString("org.quartz.jobStore.misfireThreshold"));
	}
}
