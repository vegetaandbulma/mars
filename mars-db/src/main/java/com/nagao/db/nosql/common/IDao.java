package com.nagao.db.nosql.common;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.nagao.db.common.Paging;

public interface IDao<E extends BasePO> {

	public boolean insert(E element);

	public boolean upsert(E element);

	public E findOne(long id);
	
	public List<E> find(Query query);

	public List<E> findAll();
	
	public Paging<E> pagingQuery(Query query, int page, int size);
	
	public void remove(Query query);
	
	public void removeOne(long id);
	
	public void removeAll();

	public void findAndModify(E query, E modify);

	public long total();
	
	public long total(Query query);
	
	public List<E> findIn(List<Long> ids);
	
	public List<E> findIn(String fieldName, List<String> list);
}
