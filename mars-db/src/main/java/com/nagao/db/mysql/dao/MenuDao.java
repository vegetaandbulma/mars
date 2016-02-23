package com.nagao.db.mysql.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Menu;

@Repository("menuDao")
public class MenuDao extends GenericDAO<Menu, String> {
	public Paging<Menu> pagingQuery(int page,int size,Map<String, Object> values,String order){
		String hql = "from " + Menu.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
	

}
