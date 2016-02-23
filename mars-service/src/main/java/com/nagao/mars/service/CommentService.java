package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.Comment;

public interface CommentService {
	public boolean addComment(Comment comment);
	public Comment oneQueryById(String memberId);
	public Comment oneQueryByMail(String email);
	public Comment oneQueryByPhone(String phone);
	public Paged<Comment> pagingQuery(int page,int size,Date from,Date to);	
}
