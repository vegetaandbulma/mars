package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;

@Entity
@Table(name = "TAB_ZONE")
public class Zone extends BasePO implements Serializable{

	private static final long serialVersionUID = 2476769305608311926L;
	
	@Column(name = "ZONE_NAME", length = 60,columnDefinition="varchar(60) comment 'zonename,'")
	private String zoneName;
	
	@Column(name = "USER_ID", length = 32,columnDefinition="varchar(32) comment 'userId'")
	private String userId;
	
	@Column(name = "ZONE_URI", length = 60,columnDefinition="varchar(60) comment 'uri,'")
	private String uri;
	
	@Column(name = "ZONE_BRIEF", length = 256,columnDefinition="varchar(256) comment 'brief'")
	private String brief;

}
