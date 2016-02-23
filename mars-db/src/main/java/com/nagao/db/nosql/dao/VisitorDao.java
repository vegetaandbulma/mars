package com.nagao.db.nosql.dao;

import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.Visitor;

@Repository
public class VisitorDao extends BaseDao<Visitor> {
	public VisitorDao(){
		super(Visitor.class);
	}
}
