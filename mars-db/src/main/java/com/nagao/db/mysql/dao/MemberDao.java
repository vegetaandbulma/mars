package com.nagao.db.mysql.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Member;

@Repository("memberDao")
public class MemberDao extends GenericDAO<Member, String> {
	public Paging<Member> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + Member.class.getSimpleName() + " t ";
		return pagingQuery(hql, values, page, size);
	}
}
