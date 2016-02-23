package com.nagao.mars.domian.vo;

import java.io.Serializable;


public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1953775843031965264L;
	private String id;
	private String name;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
