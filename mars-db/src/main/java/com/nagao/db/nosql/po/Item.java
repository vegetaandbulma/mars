package com.nagao.db.nosql.po;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.nagao.db.nosql.common.BasePO;
@Document(collection = "item")
public class Item  extends BasePO implements Serializable {

	private static final long serialVersionUID = -7608320725268826206L;
	
	private String image;
	private String title;
	private String brief;

}
