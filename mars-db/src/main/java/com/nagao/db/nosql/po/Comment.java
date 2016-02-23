package com.nagao.db.nosql.po;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;

@Document(collection = "comment")
public class Comment extends BasePO implements Serializable {

	private static final long serialVersionUID = -3714724911718975400L;
	
	private String fKey;
	private String content;
	private int reply;
	private int floor;
	private int status;
	private String userId;
	public String getfKey() {
		return fKey;
	}
	public void setfKey(String fKey) {
		this.fKey = fKey;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
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
