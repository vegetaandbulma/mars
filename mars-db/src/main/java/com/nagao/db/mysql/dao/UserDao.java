package com.nagao.db.mysql.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.User;

@Repository("userDao")
public class UserDao extends GenericDAO<User, String> {
	public Paging<User> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + User.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
	
	public User loginQuery(String name,String email){
		String hql = "from " + User.class.getSimpleName() + " t where 1=1 and  status = 0";
		Map<String,Object> values = new HashMap<String,Object>();
		if(name != null && !name.isEmpty()){
			hql = hql + " and userName=:userName";
			values.put("userName", name);
		}
		if(email != null && !email.isEmpty()){
			hql = hql + " and email=:email";
			values.put("email", email);
		}
		
		return this.findOne(hql, values);
	}
}
