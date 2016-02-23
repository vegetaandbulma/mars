//package com.nagao.db.mysql.dao;
//
//import java.util.Map;
//
//import org.springframework.stereotype.Repository;
//
//import com.nagao.db.common.Paging;
//import com.nagao.db.mysql.base.GenericDAO;
//import com.nagao.db.mysql.po.RoleLimit;
//
//@Repository("roleLimitDao")
//public class RoleLimitDao extends GenericDAO<RoleLimit, String> {
//	public Paging<RoleLimit> pagingQuery(int page,int size,Map<String, Object> values,String order){
//		String hql = "from " + RoleLimit.class.getSimpleName() + " t ";
//		return pagingQuery(hql, values, page, size);
//	}
//	
//
//}
