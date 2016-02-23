package com.nagao.framework.data;

import java.io.Serializable;

public class SessionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8378376931613343185L;
	
	private String userName;
	
	private String userPassword;
	
	private Object obj;
	
	private String themes;

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
