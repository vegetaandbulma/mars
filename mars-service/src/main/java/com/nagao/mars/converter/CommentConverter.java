package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagao.mars.domian.vo.Comment;

public class CommentConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Comment converter(com.nagao.db.nosql.po.Comment m){
		Comment comment =new Comment();
		comment.setId(m.getpKey());
		comment.setfKey(m.getfKey());
		comment.setFloor(m.getFloor());
		comment.setReply(m.getReply());
		comment.setUserId(m.getUserId());
		comment.setContent(m.getContent());
		comment.setCreateDate(format.format(m.getCreateDate()));
		comment.setModifyDate(format.format(m.getCreateDate()));
		return comment;
	}
	
	public static com.nagao.db.nosql.po.Comment reverse(Comment comment){
		com.nagao.db.nosql.po.Comment c = new com.nagao.db.nosql.po.Comment();		
		c.setfKey(comment.getfKey());
		c.setFloor(comment.getFloor());
		c.setReply(comment.getReply());
		c.setUserId(comment.getUserId());
		c.setContent(comment.getContent());		
		c.setCreateDate(new Date());
		return c;
	}
	
	public static List<Comment> batch(List<com.nagao.db.nosql.po.Comment> cs){
		List<Comment> ls = new ArrayList<Comment>();
		if(cs !=null){
			for(com.nagao.db.nosql.po.Comment m:cs){
				ls.add(CommentConverter.converter(m));
			}
		}
		return ls;
	}
}
