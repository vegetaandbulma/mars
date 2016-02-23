package com.nagao.framework.context;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextRegister implements ApplicationContextAware {
	
	private static Log log = LogFactory.getLog(ApplicationContextRegister.class);
	public ApplicationContextRegister() {		
		// TODO Auto-generated constructor stub
		log.debug(" register appContext ");
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub		
		ApplicationContextUtils.setApplicationContext(arg0);
		log.debug(" register appContext ok .   ApplicationContextUtils.getAppContext() fun  to get bean");
	}

}
