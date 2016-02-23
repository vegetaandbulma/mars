package com.nagao.framework.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
/**
 * 
 * @author donghuana
 *
 */
public class ApplicationContextUtils {
	static ApplicationContext wac = null;

	public static ApplicationContext getAppContext(){
		return wac;
	}


	public static void setApplicationContext(ApplicationContext app) throws BeansException {
		// TODO Auto-generated method stub
		wac = (ApplicationContext) app;
	}
}
