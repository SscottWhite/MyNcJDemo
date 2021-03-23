package com.example.jsptest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver htmlViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }
 
    @Bean
    public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(HandleResourceViewExists.class); //设置检查器
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(0);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }
 }
