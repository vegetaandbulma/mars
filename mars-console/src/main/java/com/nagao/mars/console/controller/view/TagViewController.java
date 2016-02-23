package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class TagViewController {

	@RequestMapping("/index")
	public String index(){
		return "tag/index";    
	}
	
	@RequestMapping("/edit")
	public String edit(){
		return "tag/edit";    
	}
}
