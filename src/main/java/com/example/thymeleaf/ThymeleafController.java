package com.example.thymeleaf;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(HttpServletRequest request, Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        model.addAttribute("color", "<span style='color:red'>color</span>");
        model.addAttribute("date", new Date());
        model.addAttribute("url", "www.baidu.cn");
        
        request.setAttribute("requestMessage", "springboot-request");
        request.setAttribute("url2", "<span style='color:red'>www.baidu.cn</span>");
        
        request.getSession().setAttribute("sessionMessage", "springboot-session");
        request.getServletContext().setAttribute("applicationMessage", "springboot-application");    
        return "show";
    }
}
