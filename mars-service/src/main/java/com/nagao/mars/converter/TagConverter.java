package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagao.mars.domian.vo.Tag;

public class TagConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Tag converter(com.nagao.db.mysql.po.Tag t){
		Tag tag = new Tag();
		tag.setId(t.getId());
		tag.setName(t.getName());
		tag.setType(t.getType());
		tag.setUrl(t.getUrl());
		tag.setCreateDate(format.format(t.getCreateDate()));
		return tag;
	}
	
	public static com.nagao.db.mysql.po.Tag reverse(Tag tag){
		com.nagao.db.mysql.po.Tag t = new com.nagao.db.mysql.po.Tag();		
		t.setId(tag.getId());
		t.setModifyDate(new Date());
		t.setCreateDate(new Date());
		t.setName(tag.getName());
		t.setType(tag.getType());
		t.setUrl(tag.getUrl());
		return t;
	}
	
	public static List<Tag> batch(List<com.nagao.db.mysql.po.Tag> ts){
		List<Tag> ls = new ArrayList<Tag>();
		if(ts !=null){
			for(com.nagao.db.mysql.po.Tag t:ts){
				ls.add(TagConverter.converter(t));
			}
		}
		return ls;
	}
}
