package com.nagao.db.nosql.dao;

import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.Comment;

@Repository
public class CommentDao extends BaseDao<Comment> {
	public CommentDao(){
		super(Comment.class);
	}
}
