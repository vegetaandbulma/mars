package com.nagao.mars.domian.vo;

import java.io.Serializable;
import java.util.Date;

public class Folder implements Serializable {

	private static final long serialVersionUID = 6610788918874146757L;
	
	private boolean isfolder;
	private String name;
	private String path;
	private Date date;
	
	public boolean isIsfolder() {
		return isfolder;
	}
	public void setIsfolder(boolean isfolder) {
		this.isfolder = isfolder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
