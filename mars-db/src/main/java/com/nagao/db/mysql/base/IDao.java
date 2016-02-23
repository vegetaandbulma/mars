package com.nagao.db.mysql.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.nagao.db.common.Paging;


public interface IDao <T extends Serializable, PK extends Serializable>{
	public T save(T entity);

	public void delete(T entity);

	public List<T> findAll(Class<T> entityClass);
	
	public Paging<T> pagingQuery(String hql,Map<String,Object> values,int page,int size);

	public T get(Class<T> aClass, PK id);
	
	public T findOne(String hql,Map<String,Object> values);

	public int update(String statement);

	public int update(String statement, Map<String, Object> params);
	
	public HibernateTemplate getTemplate();
}
