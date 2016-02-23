package com.nagao.mars.domian.vo;

import java.io.Serializable;

public class Document implements Serializable {

	private static final long serialVersionUID = -1455733541551701042L;
	
	private String id;
	private String title;
	private String content;
	private String createDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
