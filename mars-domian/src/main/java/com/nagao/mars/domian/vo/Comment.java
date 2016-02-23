package com.nagao.mars.domian.vo;

import java.io.Serializable;


public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6388746837470367011L;
	private String id;
	private String fKey;
	private String content;
	private int reply;
	private int floor;
	private String userId;
	private String createDate;
	private String modifyDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
}
