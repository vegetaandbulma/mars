package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;
@Entity
@Table(name = "TAB_VERSION")
public class VersionControl extends BasePO implements Serializable {

	private static final long serialVersionUID = 307535521924426966L;	
	
	@Column(name = "PLATFORM", length = 20,columnDefinition="varchar(20) comment 'platform'")
	private String platform;
	
	@Column(name = "VERSION", length = 20,columnDefinition="varchar(20) comment 'version'")
	private String version;
	
	@Column(name = "BRIEF", length = 128,columnDefinition="varchar(128) comment 'brief'")
	private String brief;
}
