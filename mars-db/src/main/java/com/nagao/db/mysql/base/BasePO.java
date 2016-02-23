package com.nagao.db.mysql.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BasePO implements Serializable {

	private static final long serialVersionUID = 8870730322616160981L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid",strategy="uuid")
	@Column(name = "ID", length=32)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE",length = 40,columnDefinition="datetime comment '时间'")
	private Date createDate;
	
	@Column(name = "MODIFY_DATE",length = 40,columnDefinition="datetime comment '时间'")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
