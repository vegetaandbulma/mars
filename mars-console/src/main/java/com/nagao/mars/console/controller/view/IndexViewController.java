package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexViewController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/login")
	public String desktop() {
		return "login";
	}
	
}
