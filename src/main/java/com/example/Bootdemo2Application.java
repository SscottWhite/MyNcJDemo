package com.example;

import java.util.Arrays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import lombok.extern.slf4j.Slf4j;
//DruidDataSourceAutoConfigure.class  可以去掉Druid自动数据源
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
/*	@Bean
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
	}*/
	
	 /**                                                                                                            
	   * @description 注册一个StatViewServlet,进行druid监控页面配置                                                               
	   * @return servlet registration bean                                                                           
	   */                                                                                                            
	  @Bean
	  public ServletRegistrationBean druidStatViewServlet() { 
	  	  //先配置管理后台的servLet，访问的入口为/druid/                                                       
	      ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(                             
	             new StatViewServlet(), "/druid/*");
	      // IP白名单 (没有配置或者为空，则允许所有访问)
	      servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
	      // IP黑名单 (存在共同时，deny优先于allow)                                                      
		  servletRegistrationBean.addInitParameter("deny", "");           
	      servletRegistrationBean.addInitParameter("loginUsername", "admin");                                        
	      servletRegistrationBean.addInitParameter("loginPassword", "admin");
	      servletRegistrationBean.addInitParameter("resetEnable", "false");                                          
	      return servletRegistrationBean;                                                                            
	  }      
	  
	  /**                                                                                                                      
	   * @description 注册一个过滤器，允许页面正常浏览                                                                   
	   * @return filter registration bean                                                                                      
	   */                                                                                                                      
	  @Bean
	  public FilterRegistrationBean druidStatFilter(){                                                                         
	      FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(                                          
	              new WebStatFilter());                                                                                        
	      // 添加过滤规则.                                                                                                           
	      filterRegistrationBean.addUrlPatterns("/*");                                                                         
	      // 添加不需要忽略的格式信息.                                                                                                     
	      filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");                
	      return filterRegistrationBean;                                                                                       
	  } 
}
