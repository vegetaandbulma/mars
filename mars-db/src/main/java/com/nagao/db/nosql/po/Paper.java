package com.nagao.db.nosql.po;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;
@Document(collection = "paper")
public class Paper extends BasePO implements Serializable {

	private static final long serialVersionUID = -1650212831989359714L;
	
	private String title;
	private String content;
	
	private String userId;
	
	private int status;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
