package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_TREE")
public class Tree extends BasePO implements Serializable {

	private static final long serialVersionUID = 4222813614926035825L;
	@Column(name = "TREE_NAME", length = 128,columnDefinition="varchar(128) comment 'name'")
	private String name;
	@Column(name = "TREE_ROOT", length = 128,columnDefinition="varchar(128) comment 'root'")
	private String root;
	@Column(name = "TREE_CODE",unique=true, length = 128,columnDefinition="varchar(128) comment 'tree code'")
	private String code;
	@Column(name = "TREE_URL", length = 256,columnDefinition="varchar(256) comment 'url'")
	private String url;
	@Column(name = "TREE_STATUS", length = 5,columnDefinition="int(5) default 0 comment 'status' ")
	private int status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
