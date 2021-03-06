package com.example.ymltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 *  展示读取文件的两种方法
 * @author KJS_352
 *
 */
@Slf4j
@RestController
@RequestMapping("/t")
@Component  //开启定时后能被扫到
public class TestYml {
	
	@Value("${user.dir}")
	public  String name;
	
	@Autowired
	private Person person;
	
	@GetMapping("/getName")
	//@Scheduled(cron = "*/5 * * * * ?")  //需要开启的方法及时间 5s/次
	public void getName() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		
		log.info(name);
		
		log.info(person.getName()+"123");
		log.info(person.getEmail());
		log.info(om.writeValueAsString(person.getAge()));
		log.info(om.writeValueAsString(person.getArrays()));
		log.info(om.writeValueAsString(person.getList()));
		log.info(om.writeValueAsString(person.getMaps()));
		log.info(om.writeValueAsString(person.getListm()));
	}
}
