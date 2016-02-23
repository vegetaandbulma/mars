package com.nagao.db.nosql.common;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class BasePO {
	@Indexed(unique=true,name="index_pKey")
	@Id
	private String pKey;
	private Date createDate;
	private Date modifyDate;
	
	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	
	public String getPKey() {
		return pKey;
	}

	public void setPKey(String pKey) {
		this.pKey = pKey;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
