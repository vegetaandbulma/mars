package com.nagao.db.mysql.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_TAG")
public class Tag extends BasePO {

	private static final long serialVersionUID = -4812788391060059765L;
	
	@Column(name = "TAG_NAME", length = 128,columnDefinition="varchar(128) comment 'name'")
	private String name;
	
	@Column(name = "TAG_TYPE", length = 32,columnDefinition="varchar(32) comment 'type'")
	private String type;
	
	@Column(name = "TAG_URL", length = 256,columnDefinition="varchar(256) comment 'url'")
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
