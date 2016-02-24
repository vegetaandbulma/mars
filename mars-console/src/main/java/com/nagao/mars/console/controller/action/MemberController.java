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
//import com.nagao.mars.service.MemberService;
//import com.nagao.mars.vo.Member;
//
//@Controller
//@RequestMapping("/member")
//public class MemberController {
//	
//	@Autowired
//	private MemberService memberService;
//	
//	@RequestMapping("/query")
//	public @ResponseBody Map<String, Object> query(int 	page,int rows){
//		Map<String,Object> map = new HashMap<String,Object>();
//		//Paged<Member> paged= memberService.pagingQuery(page, rows, null, null);
//		//return NormResponse.format(true, paged.getTotal(), paged.getRows(), "ok");
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
