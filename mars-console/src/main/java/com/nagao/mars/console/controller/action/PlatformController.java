package com.nagao.mars.console.controller.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagao.framework.data.JsonResponse;
import com.nagao.mars.domian.vo.Menu;
import com.nagao.mars.service.PlatformService;

@Controller
@RequestMapping("/platform")
public class PlatformController {
	
	@Autowired
	private PlatformService platformService;
	
	@RequestMapping("/menu")
	public @ResponseBody Map<String, Object> list(){
		List<Menu> ms = platformService.get("");
		return JsonResponse.format(true, ms, "menu list");
	}

}
