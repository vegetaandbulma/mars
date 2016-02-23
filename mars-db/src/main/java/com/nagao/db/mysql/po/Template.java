package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_TEMPLATE")
public class Template extends BasePO implements Serializable {

	private static final long serialVersionUID = -2495798891822814511L;
	@Column(name = "TEMP_NAME", length = 128,columnDefinition="varchar(128) comment 'name'")
	private String name;
	@Column(name = "TEMP_CONTENT", length = 1024,columnDefinition="TEXT" )
	private String content;
	@Column(name = "TEMP_TYPE", length = 10,columnDefinition="varchar(10) comment 'tempType'")
	private String tempType;
	@Column(name = "USER_ID", length = 32,columnDefinition="varchar(32) comment 'userId'")
	private String userId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTempType() {
		return tempType;
	}
	public void setTempType(String tempType) {
		this.tempType = tempType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	} 
}
