package com.nagao.db.mysql.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.base.GenericDAO;
import com.nagao.db.mysql.po.Tree;

@Repository("treeDao")
public class TreeDao extends GenericDAO<Tree, String> {
	
	public Paging<Tree> getNodes(int page,int size,String code,String order){		
		String hql = "from " + Tree.class.getSimpleName() + " t where 1=1 and root=:root ";
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("root", code);
		return pagingQuery(hql, values, page, size);
	}
	
	public Paging<Tree> pagingQuery(int page,int size,Map<String, Object> values,String order){		
		String hql = "from " + Tree.class.getSimpleName() + " t where 1=1 and root=:root ";
		return pagingQuery(hql, values, page, size);
	}
	
	public boolean status(String Id,int status){
		StringBuilder hqlBuilder = new StringBuilder("update " + Tree.class.getSimpleName() + " p set ");
		hqlBuilder.append(" p.modifyDate = :now");
		hqlBuilder.append(" p.status = :status");
		hqlBuilder.append(" where p.id = :Id ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",Id);
		params.put("status",status);
		params.put("now",new Date());
		int result = this.update(hqlBuilder.toString(), params);
		if(result > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean update(String id,String name,String url,String root,String code){
		StringBuilder hqlBuilder = new StringBuilder("update " + Tree.class.getSimpleName() + " p set ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		hqlBuilder.append(" p.modifyDate = :now");
		if(name !=null && !name.isEmpty()){
			hqlBuilder.append(" ,p.name = :name");
			params.put("name",name);
		}
		if(url!=null&&!url.isEmpty()){
			hqlBuilder.append(" ,p.url = :url");
			params.put("url",url);
		}	
		if(root!=null&&!root.isEmpty()){
			hqlBuilder.append(" ,p.root = :root");
			params.put("root",root);
		}	
		if(code!=null&&!code.isEmpty()){
			hqlBuilder.append(" ,p.code = :code");
			params.put("code",code);
		}	
		hqlBuilder.append(" where p.id = :id ");		
		params.put("id",id);
		params.put("now",new Date());
		
		int result = this.update(hqlBuilder.toString(), params);
		if(result > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public long getTotalTreeNodeCount(){
		String hql = "from " + Tree.class.getSimpleName() + " t";//  where status=:status ";
		Map<String,Object> values = new HashMap<String,Object>();
		//values.put("status", 1);
		return this.getCount(hql, values);
	}
}
