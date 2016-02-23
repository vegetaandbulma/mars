package com.nagao.db.nosql.dao;

import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.Meun;

@Repository
public class MeunDao extends BaseDao<Meun> {
	public MeunDao(){
		super(Meun.class);
	}
}
