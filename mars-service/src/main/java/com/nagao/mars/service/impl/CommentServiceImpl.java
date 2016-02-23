package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.common.Paging;
import com.nagao.db.nosql.dao.CommentDao;
import com.nagao.framework.data.Paged;
import com.nagao.mars.converter.CommentConverter;
import com.nagao.mars.domian.vo.Comment;
import com.nagao.mars.service.CommentService;


@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public boolean addComment(Comment comment) {
		return commentDao.insert(CommentConverter.reverse(comment));
	}
	
	@Override
	public Comment oneQueryById(String memberId) {
		
		return null;
	}
	@Override
	public Comment oneQueryByMail(String email) {
		
		return null;
	}
	@Override
	public Comment oneQueryByPhone(String phone) {
		
		return null;
	}
	@Override
	public Paged<Comment> pagingQuery(int page, int size, Date from, Date to) {
		Paged<Comment>  paged =new Paged<Comment>(); 
		Paging<com.nagao.db.nosql.po.Comment> p = commentDao.pagingQuery(null, page, size);
		paged.setTotal(p.getTotal());
		paged.setRows(CommentConverter.batch(p.getRows()));
		return paged;
	}
}
