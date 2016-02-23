package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;

@Entity
@Table(name = "TAB_MEMBER")
public class Member extends BasePO implements Serializable {

	private static final long serialVersionUID = 4481575157209171288L;
	
	@Column(name = "NICK_NAME",unique=true,length = 128,columnDefinition="varchar(128) comment 'nickname'")
	private String nickname;
	
	@Column(name = "EMAIL",unique=true,length = 256,columnDefinition="varchar(256) comment 'email'")
	private String email;
	
	@Column(name = "PASSWORD", length = 10,columnDefinition="varchar(10) comment 'password'")
	private String password;
	
	@Column(name = "TELE_PHONE", length = 10,columnDefinition="varchar(10) comment 'telephone'")
	private String telephone;
	
	@Column(name = "MOBILE_PHONE", length = 10,columnDefinition="varchar(10) comment 'mobilephone'")
	private String mobilephone;
	
	@Column(name = "DEVICE", length = 20,columnDefinition="varchar(20) comment 'device'")
	private String device;
	
	@Column(name = "STATUS", length = 5,columnDefinition="int(5) default 0 comment 'status' ")
	private int status;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
