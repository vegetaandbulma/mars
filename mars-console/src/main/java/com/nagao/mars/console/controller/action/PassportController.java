package com.nagao.mars.console.controller.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagao.framework.data.NormResponse;
import com.nagao.framework.data.NormCodeConst;
import com.nagao.framework.data.Result;
import com.nagao.mars.console.controller.BaseController;
import com.nagao.mars.console.utils.MessageSourceUtil;
import com.nagao.mars.domian.vo.User;
import com.nagao.mars.service.PassportService;


@Controller
@RequestMapping("/passport")
public class PassportController extends BaseController  {
	
	@Autowired
	private PassportService passportService;
	
//	@Autowired
//	private SessionManager sessionManager;
	
	@RequestMapping("/login")
	public @ResponseBody Map<String, Object> login(String username,String email,String password){
		Result<User> r = passportService.login(username, email ,password, "");
		//sessionManager.setUser(r.getObject(),this.response);
		return NormResponse.format(r.isSuccess(), r.getObject(), r.getMessage());
	}
	
	@RequestMapping("/logout")
	public @ResponseBody Map<String, Object> logout(){
		return NormResponse.format(true, 0, null, "");
	}
	
	@RequestMapping("/register")
	public @ResponseBody Map<String, Object> register(User userVo){
		boolean r = passportService.register(userVo);
		if(r){
			return NormResponse.format(r, null, MessageSourceUtil.getMessage(request, NormCodeConst.SUCCESS));
		} else {
			return NormResponse.format(r, null, MessageSourceUtil.getMessage(request, NormCodeConst.FAIL));
		}
	}
}
