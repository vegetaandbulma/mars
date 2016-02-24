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
//import com.nagao.mars.service.DocService;
//import com.nagao.mars.vo.Document;
//
//@Controller
//@RequestMapping("/paper")
//public class PaperController {
//	
//	@Autowired
//	private DocService docService;
//	
//	@RequestMapping("/add")
//	public @ResponseBody Map<String, Object> add(Document doc){
//		Map<String,Object> map = new HashMap<String,Object>();
//		docService.addDoc(doc);
//		return NormResponse.format(true, map, "ok");
//	}	
//	
//	@RequestMapping("/query")
//	public @ResponseBody Map<String, Object> query(int 	page,int rows){
//		Paged<Document> paged= docService.pagingQuery(page, rows, null, null);
//		return NormResponse.format(true, paged.getTotal(), paged.getRows(), "ok");
//	}		
//
//}
