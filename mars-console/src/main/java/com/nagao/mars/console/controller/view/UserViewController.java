package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserViewController {

	@RequestMapping("/index")
	public String index(){
		return "user/index";
	}
	
	@RequestMapping("/edit")
	public String edit(){
		return "user/edit";
	}
}
