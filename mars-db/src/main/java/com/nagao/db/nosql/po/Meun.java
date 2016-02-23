package com.nagao.db.nosql.po;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;

@Document(collection = "meun")
public class Meun  extends BasePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7091853124489582591L;
	@Id
	@Indexed
	private String mid;
	private String text;
	private String uri;
	private int order;
	

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}
