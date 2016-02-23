package com.nagao.db.nosql.po;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;

@Document(collection = "cacheObject")
public class CacheObject extends BasePO {
	
	@Indexed(unique=true,name="index_Key")
	private String key;
	private byte[] data;
	private long alive;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}

	public long getAlive() {
		return alive;
	}
	public void setAlive(long alive) {
		this.alive = alive;
	}
}
