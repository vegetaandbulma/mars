package com.nagao.db.mysql.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_PAGE")
public class Page extends BasePO {

	private static final long serialVersionUID = -4812788391060059765L;
	
	@Column(name = "PAGE_NAME", length = 128,columnDefinition="varchar(128) comment 'name'")
	private String name;
	
	@Column(name = "PAGE_TYPE", length = 32,columnDefinition="varchar(32) comment 'type'")
	private String type; 
	
	@Column(name = "PAGE_CATEGORY", length = 32,columnDefinition="varchar(32) comment 'category'")
	private String category; 
	
	@Column(name = "PAGE_URL", length = 256,columnDefinition="varchar(256) comment 'url'")
	private String url;
	
	@Column(name = "PAGE_PATH", length = 256,columnDefinition="varchar(256) comment 'path'")
	private String path;
	
	@Column(name = "PAGE_TEMPLATE", length = 32,columnDefinition="varchar(32) comment 'templateId'")
	private String templateId;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
