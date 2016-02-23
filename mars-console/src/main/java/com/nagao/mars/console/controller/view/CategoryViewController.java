package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryViewController {

	@RequestMapping("/index")
	public String index(){
		return "category/index";    
	}
	
	@RequestMapping("/newNode")
	public String newNode(){
		return "category/newNode";    
	}

}
