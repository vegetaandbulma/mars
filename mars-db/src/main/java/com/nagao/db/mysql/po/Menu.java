package com.nagao.db.mysql.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_MENU")
public class Menu extends BasePO {

	private static final long serialVersionUID = -4812788391060059765L;
	
	@Column(name = "MENU_NAME", length = 128,columnDefinition="varchar(128) comment 'name'")
	private String name;
	
	@Column(name = "MENU_ICON", length = 32,columnDefinition="varchar(10) comment 'type'")
	private String type;
	
	@Column(name = "MENU_URI", length = 256,columnDefinition="varchar(256) comment 'url'")
	private String url;
	
	@Column(name = "MENU_PARENT_ID", length = 32,columnDefinition="varchar(32) comment 'parentId'")
	private String parentId;
	
	@Column(name = "MENU_LEVEL", length = 32,columnDefinition="int(5) default 0 comment 'level'")
	private int level;

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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
