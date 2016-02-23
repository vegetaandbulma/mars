package com.nagao.mars.console.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestContext;

public class MessageSourceUtil {
	public static String getMessage(HttpServletRequest request,String message){
		RequestContext requestContext = new RequestContext(request);
		return requestContext.getMessage(message);
	}
}
