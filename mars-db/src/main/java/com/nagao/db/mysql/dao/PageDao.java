package com.nagao.db.mysql.dao;

import java.util.Map;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Page;

public class PageDao extends GenericDAO<Page, String> {
	public Paging<Page> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + Page.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
}
