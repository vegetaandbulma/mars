package com.nagao.db.mysql.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Role;

@Repository("roleDao")
public class RoleDao extends GenericDAO<Role, String> {
	public Paging<Role> pagingQuery(int page,int size,Map<String, Object> values,String order){
		String hql = "from " + Role.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
	

}
