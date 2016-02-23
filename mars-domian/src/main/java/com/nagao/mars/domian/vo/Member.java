package com.nagao.mars.domian.vo;

import java.io.Serializable;


public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3533974371983036803L;
	private String id;
	private String name;
	private String email;
	private String telephone;
	private String createDate;
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
}
