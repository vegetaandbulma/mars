//package com.nagao.db.mysql.po;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import com.nagao.db.mysql.base.BasePO;
//
//@Entity
//@Table(name = "TAB_ROLE_LIMIT")
//public class RoleLimit extends BasePO implements Serializable {
//
//	private static final long serialVersionUID = 5533094885067033479L;
//	@Column(name = "ROLE_ID",unique=true, length = 60,columnDefinition="varchar(32) comment 'roleId'")
//	private String roleId;
//	@Column(name = "MENU_ID",unique=true, length = 60,columnDefinition="varchar(32) comment 'menuId'")
//	private String menuId;
//	@Column(name = "LIMIT", length = 32,columnDefinition="int(5) default 0 comment 'limit'")
//	private int limit; 
//	@Column(name = "STATUS", length = 5,columnDefinition="int(5) default 0 comment 'status' ")
//	private int status;
//
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//	public String getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(String roleId) {
//		this.roleId = roleId;
//	}
//
//	public int getLimit() {
//		return limit;
//	}
//
//	public void setLimit(int limit) {
//		this.limit = limit;
//	}
//
//	public String getMenuId() {
//		return menuId;
//	}
//
//	public void setMenuId(String menuId) {
//		this.menuId = menuId;
//	}
//}
