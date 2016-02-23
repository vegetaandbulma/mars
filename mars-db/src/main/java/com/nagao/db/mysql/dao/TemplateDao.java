package com.nagao.db.mysql.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Template;

@Repository("templateDao")
public class TemplateDao extends GenericDAO<Template, String> {
	public Paging<Template> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + Template.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
}
