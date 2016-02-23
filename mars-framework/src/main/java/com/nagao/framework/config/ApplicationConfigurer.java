package com.nagao.framework.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class ApplicationConfigurer extends PropertyPlaceholderConfigurer {
	private static Log log = LogFactory.getLog(ApplicationConfigurer.class);
	
	private static Map<String, Object> configurer;  
	
	@Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {  
        super.processProperties(beanFactoryToProcess, props);  
        configurer = new HashMap<String, Object>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            configurer.put(keyStr, value);
            log.debug("Properties configurer keyStr=>"+keyStr+"  value=>"+value);
        }  
    }  
  
    public static String getPropertiesParm(String name) {  
        return (String)configurer.get(name);  
    } 
}
