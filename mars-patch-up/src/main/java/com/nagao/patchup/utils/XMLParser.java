package com.nagao.patchup.utils;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration.XMLConfiguration;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XMLParser {
	private XMLConfiguration xmlConfig = null;
	private Document document = null; 
	public XMLParser(String filepath){
		if(xmlConfig == null){
			SAXReader saxReader = new SAXReader();
			xmlConfig = new XMLConfiguration();
			try {
				document = saxReader.read(new File(filepath));
				xmlConfig.load(filepath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Node getNode(String xpathExpression){
		return document.selectSingleNode(xpathExpression);
	}
	
	public Document getDocument(){
		return document;
	}
	
	public List getNodes(String xpathExpression){
		return document.selectNodes(xpathExpression);
	}
	
	public String getString(String key){
		if(xmlConfig != null){
			return xmlConfig.getString(key);
		} else {
			return "";
		}
	}
	
	public String getList(String key){
		if(xmlConfig != null){
			return xmlConfig.getString("classpathentry[@kind = 'output' ][@path]");
		} else {
			return "";
		}
	}
}
