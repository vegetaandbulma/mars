package com.nagao.mars.console.controller.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.util.VersionUtil;
import com.nagao.framework.data.NormResponse;
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
		return NormResponse.format(true, ms, "menu list");
	}
	
	@RequestMapping("/version")
	public @ResponseBody Map<String, Object> version(){
		Properties properties = new Properties();
		try {
			properties.load(VersionUtil.class.getResourceAsStream("/version.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NormResponse.format(true, null, properties.getProperty("version"));
	}

}
