package com.nagao.mars.console.controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagao.framework.data.JsonResponse;
import com.nagao.framework.data.NormCodeConst;
import com.nagao.framework.data.Paged;
import com.nagao.mars.console.controller.BaseController;
import com.nagao.mars.console.utils.MessageSourceUtil;
import com.nagao.mars.domian.vo.Category;
import com.nagao.mars.domian.vo.Node;
import com.nagao.mars.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(Category category){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean r = categoryService.addNode(category);
		if(r){
			return JsonResponse.format(r, map, MessageSourceUtil.getMessage(request, NormCodeConst.SUCCESS));
		} else {
			return JsonResponse.format(r, map, MessageSourceUtil.getMessage(request, NormCodeConst.FAIL));
		}
	}	
	
	@RequestMapping("/nodes")
	public @ResponseBody List<Node> nodes(String id){
		Paged<Node> paged= categoryService.getNodes(-1, -1, id);
		return paged.getRows();
	}	
	
	@RequestMapping("/get")
	public @ResponseBody Map<String, Object> get(String id){
		Category category = categoryService.getNode(id);
		return JsonResponse.format(true, category, "ok");
	}
	
	@RequestMapping("/modify")
	public @ResponseBody Map<String, Object> modify(Category category){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean r = categoryService.modifyNode(category);
		if(r){
			return JsonResponse.format(r, map, "ok");
		} else {
			return JsonResponse.format(r, map, "fail");
		}
	}
	
	@RequestMapping("/remove")
	public @ResponseBody Map<String, Object> remove(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean r = categoryService.deleteNode(id);
		if(r){
			return JsonResponse.format(r, map, "ok");
		} else {
			return JsonResponse.format(r, map, "fail");
		}	
	}
	
	@RequestMapping("/hide")
	public @ResponseBody Map<String, Object> hide(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		boolean r = categoryService.hideNode(id);
		if(r){
			return JsonResponse.format(r, map, "ok");
		} else {
			return JsonResponse.format(r, map, "fail");
		}		
	}
}
