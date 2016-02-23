package com.nagao.db.nosql.dao;

import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.Paper;

@Repository
public class PaperDao extends BaseDao<Paper> {
	public PaperDao(){
		super(Paper.class);
	}
}
