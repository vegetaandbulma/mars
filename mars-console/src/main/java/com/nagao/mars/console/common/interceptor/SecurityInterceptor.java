package com.nagao.mars.console.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * spring 拦截器 进行权限验证 ，判断当前 ServletPath 是否 存在于 用户的 权限列表中，不存在则 没有权限
 * @author donghuana
 *
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static Log log = LogFactory.getLog(SecurityInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		// 
//		boolean hasAuthority = false;
//		HandlerMethod handlerMethod = (HandlerMethod) handler;
//		ResponseBody responseBody = handlerMethod.getReturnType().getMethodAnnotation(ResponseBody.class);
//		System.out.println(" SecurityInterceptor ");
//		System.out.println(" requestMapping " + request.getServletPath());
//		if(hasAuthority){			//是否有权限				
//			return true;
//		}else{
//			if(responseBody!=null){ //ajax 方式 返回
//				System.out.println(" Ajax ");
//			}else{					//非ajax 方式 返回 重定向 跳转
//				System.out.println(" no Ajax ");
//				request.getRequestDispatcher("/transform/console.do").forward(request, response);
//				return false;
//			}
//			return false;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,	ModelAndView modelAndView) throws Exception {
		// 
		log.debug("");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		// 

	}

}
