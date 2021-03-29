package com.example.toolutils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/test")
public class HttpsTest {
    @RequestMapping("/httpclient")
    public @ResponseBody  String  httpClient() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentId", "13026194071");
        HttpClientUtils.doPost("http://119.253.35.74:8099/GCSJ/login", null);
        return "sendPost";
    }
    //@RequestMapping("/http")
    @GetMapping("/https")
    public @ResponseBody  String  http(HttpServletRequest request,HttpServletResponse  response) throws IOException {
        //	HttpUtils.doPost("http://119.253.35.74:8099/GCSJ/login", "");
        System.out.println(request.getRequestURI()+";"+request.getProtocol());
        //设置返回客户端的contentType
        response.setContentType("text/html;charset=utf-8");
        //设置状态码
        //response.setStatus(500);
        //response.sendError(500);
        // PrintWriter out = response.getWriter();
        //out.println("虽然我的状态为500，但是信息正常输出了");
        //添加类型为String的header
        response.addHeader("Location", "#");
        //添加类型为long的header
        response.addDateHeader("Date", new Date().getTime());
        //创建一个Cookie
        Cookie cookie = new Cookie("name", "李子树");
        //添加一个cookie
        response.addCookie(cookie);

        return "sendPost";
    }
}

