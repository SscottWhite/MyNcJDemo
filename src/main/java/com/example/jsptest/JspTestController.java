package com.example.jsptest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JspTestController {
	
	@RequestMapping("/jsp")
	public String toJps(Model model) {
		model.addAttribute("welcome", "不建议使用jsp");
		System.out.print("123启动");
		return "Login";
	}
}
