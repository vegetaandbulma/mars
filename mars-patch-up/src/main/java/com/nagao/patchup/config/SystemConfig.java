package com.nagao.patchup.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;


public class SystemConfig {
	
	private static SystemConfig sysConfig;
	
	private XMLConfiguration xmlConfig = null;
	
	private SystemConfig(){
		
	}
	
	public static XMLConfiguration getInstance(){
		if (sysConfig == null) {
			sysConfig = new SystemConfig();
			sysConfig.loadConfig();
		}
		return sysConfig.xmlConfig;
	}
	
	private void loadConfig(){
		if(xmlConfig == null){
			xmlConfig = new XMLConfiguration();
			xmlConfig.setDelimiter(',');
			try {
				xmlConfig.load("config.xml");
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
		}
	}

}
