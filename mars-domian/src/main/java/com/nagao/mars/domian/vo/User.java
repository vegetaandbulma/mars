package com.nagao.mars.domian.vo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 722175840766855630L;
	
	private String userId;
	private String name;
	private String email;
	private String telephone;
	private String createDate;
	private String password;
	private String status;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email
				+ ", telephone=" + telephone + ", createDate=" + createDate
				+ ", password=" + password + ", status=" + status + "]";
	}
}
