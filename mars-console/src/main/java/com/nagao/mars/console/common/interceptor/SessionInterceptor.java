package com.nagao.mars.console.common.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagao.framework.data.GlobalStatusCode;
import com.nagao.framework.data.NormResponse;

/**
 * spring 拦截器 判断 用户是否登录，没有登录 跳转去登陆
 * @author donghuana
 *
 */
public class SessionInterceptor implements HandlerInterceptor{	
	private static Log log = LogFactory.getLog(SessionInterceptor.class);
	
	private List<String> allows = new ArrayList<String>();

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		//放过例外
		log.debug(" Session Interceptor ==> " + request.getServletPath());
		if(request.getServletPath().indexOf("login.json") <= 0){
		//if(allows.contains(request.getServletPath()) && request.getServletPath().indexOf("login") <= 0){
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		//RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);
		ResponseBody responseBody = handlerMethod.getReturnType().getMethodAnnotation(ResponseBody.class);
		//User u = sessionManager.getUser(request);
		//无会话，跳转登陆页。
//		if(u != null){
//			return true;
//		}
		if(responseBody!=null){
			log.debug(" Ajax ");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(NormResponse.format(GlobalStatusCode.SESSION_TIME_OUT));
			//设置状态码
			//response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			//设置ContentType
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			//避免乱码
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache, must-revalidate");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}else{
			log.debug(" no Ajax ");
			//request.getRequestDispatcher("/").forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,	ModelAndView modelAndView) throws Exception {
		// 

	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		// 
		//HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		//RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);
		//ResponseBody responseBody = handlerMethod.getReturnType().getMethodAnnotation(ResponseBody.class);
		
		if(ex != null){
			System.out.println("has exception !!!");
		}

	}

	public List<String> getAllows() {
		return allows;
	}

	public void setAllows(List<String> allows) {
		this.allows = allows;
	}
}
