package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;

import com.nagao.db.mysql.base.BasePO;

public class Wiki extends BasePO implements Serializable{

	private static final long serialVersionUID = 6762706735921363203L;
	
	@Column(name = "WIKI_TITLE", length = 256,columnDefinition="varchar(256) comment 'title'")
	private String title;
	@Column(name = "WIKI_BRIEF", length = 256,columnDefinition="varchar(256) comment 'brief'")
	private String brief;
	@Column(name = "WIKI_CONTENT", length = 1024,columnDefinition="CLOB" )
	private String content;
	@Column(name = "WIKI_TREE_ID", length = 10,columnDefinition="varchar(10) comment 'treeId'")
	private String treeId;
	@Column(name = "USER_ID", length = 32,columnDefinition="varchar(32) comment 'userId'")
	private String userId;
}
