
package com.example.newpackage.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.newpackage.service.UserService;
import com.example.toolutils.HttpClientUtils;
import com.example.toolutils.HttpUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserControl {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    public void getUserService() {
        log.info("123");
        log.info(userService.getUSer().toString());
//       / return userService.getUSer();
    }
    
    @RequestMapping("/httpclient")
	public @ResponseBody  String  httpClient() {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentId", "13026194071");
		HttpClientUtils.doPost("http://119.253.35.74:8099/GCSJ/login", null);
		return "sendPost";
	}
	@RequestMapping("/http")
	public @ResponseBody  String  http() {
		HttpUtils.doPost("http://119.253.35.74:8099/GCSJ/login", "");
		return "sendPost";
	}
}
