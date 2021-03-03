package com.example.ymltest;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 *@ConfigurationProperties 注解向Spring Boot声明该类中的所有属性和配置文件中相关的配置进行绑定。
  prefix = "person"：声明配置前戳，将该前戳下的所有属性进行映射。
  @Component 或者@Configuration：将该组件加入Spring Boot容器，只有这个组件是容器中的组件，配置才生效。
 */

@Validated  // 或者@Configuration   // 自定义配置文件时，可以使用@Validated注解对注入的值进行一些简单的校验，
@Component
@ConfigurationProperties(prefix="person")  //指向配置文件的前缀 比如person.name
//@PropertySource(value="classpath:person.properties")
@Data
public class Person {
	
	 private String name;
	 private Integer age;
	// @Email
	 private  String email;
		
	 private Map<String,String> maps;
	 private List<String> list;	
	 private String[] arrays;
	 private List<Map<String,String>> listm;
}
