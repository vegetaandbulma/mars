//package com.nagao.mars.console.controller.action;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.nagao.framework.data.NormResponse;
//import com.nagao.mars.service.CommentService;
//import com.nagao.mars.vo.Comment;
//
//@Controller
//@RequestMapping("/comment")
//public class CommentController {
//	
//	@Autowired
//	private CommentService commentService;
//	
//	@RequestMapping("/add")
//	public @ResponseBody Map<String, Object> add(Comment comment){
//		Map<String,Object> map = new HashMap<String,Object>();
//		//commentService.addComment(comment);
//		return NormResponse.format(true, map, "ok");
//	}	
//	
//	@RequestMapping("/query")
//	public @ResponseBody Map<String, Object> query(int 	page,int rows){
//		//Paged<Comment> paged= commentService.pagingQuery(page, rows, null, null);
//		//return NormResponse.format(true, paged.getTotal(), paged.getRows(), "ok");
//		Map<String,Object> map = new HashMap<String,Object>();
//		return NormResponse.format(true, map, "menu list"); 
//	}	
//	
//	@RequestMapping("/get")
//	public @ResponseBody Map<String, Object> get(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		return NormResponse.format(true, map, "menu list");
//	}
//	
//	@RequestMapping("/modify")
//	public @ResponseBody Map<String, Object> modify(){
//		Map<String,Object> map = new HashMap<String,Object>();
//		return NormResponse.format(true, map, "menu list");
//	}
//}
