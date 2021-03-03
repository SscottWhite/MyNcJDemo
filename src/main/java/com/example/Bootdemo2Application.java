package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Bootdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootdemo2Application.class, args);
	}

}
