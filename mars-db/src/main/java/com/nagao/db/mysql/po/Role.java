package com.nagao.db.mysql.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nagao.db.mysql.base.BasePO;

@Entity
@Table(name = "TAB_ROLE")
public class Role extends BasePO implements Serializable {

	private static final long serialVersionUID = 5533094885067033479L;
	@Column(name = "ROLE_NAME",unique=true, length = 60,columnDefinition="varchar(60) comment 'roleName'")
	private String roleName;
	
	@Column(name = "STATUS", length = 5,columnDefinition="int(5) default 0 comment 'status' ")
	private int status;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
