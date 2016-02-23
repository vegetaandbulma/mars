package com.nagao.db.nosql.po;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;


@Document(collection = "visitor")
public class Visitor extends BasePO implements Serializable {

	private static final long serialVersionUID = 6986000386213758911L;
	
	private String fKey;
	private String keyCode;
	private String client;
	private String deviceId;
	private String action;
	

}
