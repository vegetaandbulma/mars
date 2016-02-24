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
//import com.nagao.framework.data.Paged;
//import com.nagao.mars.service.TagService;
//import com.nagao.mars.vo.Tag;
//
//@Controller
//@RequestMapping("/tag")
//public class TagController {
//	
//	@Autowired
//	private TagService tagService;
//	
//	@RequestMapping("/add")
//	public @ResponseBody Map<String, Object> add(Tag tag){
//		Map<String,Object> map = new HashMap<String,Object>();
//		boolean r = tagService.addTag(tag);
//		if(r){
//			return NormResponse.format(r, map, "ok");
//		} else {
//			return NormResponse.format(r, map, "fail");
//		}
//	}	
//	
//	@RequestMapping("/query")
//	public @ResponseBody Map<String, Object> query(int 	page,int rows){
//		Paged<Tag> paged= tagService.pagingQuery(page, rows, null, null);
//		return NormResponse.format(true, paged.getTotal(), paged.getRows(), "ok");
//	}
//	
//	@RequestMapping("/get")
//	public @ResponseBody Map<String, Object> get(String id){
//		//Category category = tagService.
//		return NormResponse.format(true, null, "ok");
//	}
//	
//
//}
