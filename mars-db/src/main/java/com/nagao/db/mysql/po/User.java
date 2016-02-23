package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;

@Entity
@Table(name = "TAB_USER")
public class User extends BasePO implements Serializable {

	private static final long serialVersionUID = 5533094885067033479L;
	@Column(name = "USER_NAME",unique=true, length = 60,columnDefinition="varchar(60) comment 'username'")
	private String userName;
	@Column(name = "EMAIL",unique=true, length = 256,columnDefinition="varchar(256) comment 'email'")
	private String email;
	@Column(name = "PASSWORD", length = 10,columnDefinition="varchar(10) comment 'password'")
	private String password;
	
	@Column(name = "TELEPHONE", length = 10,columnDefinition="varchar(10) comment 'telephone'")
	private String telephone;
	
	@Column(name = "OFFICE", length = 10,columnDefinition="varchar(10) comment 'office'")
	private String office;
	
	@Column(name = "ROLE", length = 10,columnDefinition="varchar(10) comment 'role'")
	private String role;	
	
	@Column(name = "STATUS", length = 5,columnDefinition="int(5) default 0 comment 'status' ")
	private int status;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
