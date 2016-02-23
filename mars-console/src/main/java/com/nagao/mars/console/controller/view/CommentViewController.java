package com.nagao.mars.console.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentViewController {

	@RequestMapping("/index")
	public String index(){
		return "comment/index";    
	}

}
