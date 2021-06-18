package com.example.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String f = "D:\\git\\Exlip\\workSpace\\MyNcJDemo\\src\\main\\resources\\application.properties";
		Properties pro = new Properties();
		pro.load(new FileInputStream(f));
		System.out.println(pro.getProperty("server.port"));
		
		//这个写入是重写 要小心
//		Properties props = new Properties();
//		props.setProperty("url", "http://www.liaoxuefeng.com");
//		props.setProperty("language", "Java");
//		props.store(new FileOutputStream(f), "这是写入的properties注释");
	}
}
