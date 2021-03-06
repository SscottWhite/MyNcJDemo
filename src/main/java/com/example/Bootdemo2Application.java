package com.example;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})  //用mapperScan的时候把这个关了
@SpringBootApplication
@EnableScheduling  //开启定时
@MapperScan("com.example")//配合@Repository
@Slf4j
public class Bootdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootdemo2Application.class, args);
	}

	/**
	   *  查看所有的bean
	 * @param ctx
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	    return args -> {
	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        int index = 1;
	        for (String beanName : beanNames) {
	            log.info("beanName {}: {} ",index,beanName);
	            index++;
	        }
	        log.info("beanCounts: {} " , ctx.getBeanDefinitionCount());
	    };
	}
}
