package com.nagao.db.mysql.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Tag;

@Repository("tagDao")
public class TagDao extends GenericDAO<Tag, String> {
	public Paging<Tag> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + Tag.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
}
