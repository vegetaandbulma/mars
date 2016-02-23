package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paper")
public class PaperViewController {

	@RequestMapping("/index")
	public String index(){
		return "paper/index";    
	}
	
	@RequestMapping("/get")
	public String get(String id){
		return "paper/get"; 
	}
}
