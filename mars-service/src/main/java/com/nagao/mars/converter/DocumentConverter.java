package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.nagao.mars.domian.vo.Document;

public class DocumentConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Document converter(com.nagao.db.nosql.po.Paper paper){
		Document document = new Document();
		document.setContent(paper.getContent());
		document.setTitle(paper.getTitle());
		document.setId(paper.getpKey());
		document.setCreateDate(format.format(paper.getCreateDate()));
		return document;
	}
	
	public static List<Document> batch(List<com.nagao.db.nosql.po.Paper> ps){
		List<Document> ls = new ArrayList<Document>();
		if(ps !=null){
			for(com.nagao.db.nosql.po.Paper m:ps){
				ls.add(DocumentConverter.converter(m));
			}
		}
		return ls;
	}
}
