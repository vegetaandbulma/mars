package com.nagao.db.nosql.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.nagao.db.common.Paging;

public abstract class BaseDao<E extends BasePO> implements IDao<E>{
	
	@Resource(name = "mongoTemplate")
	protected MongoTemplate mongoTemplate;
	
	protected Class<E> entityClass;
	
	private static String PK = "pKey";
	
	public BaseDao(Class<E> c){
		this.entityClass = c;
	}
	
	@Override
	public boolean upsert(E element) {
		//mongoTemplate.upsert(query, update, entityClass, collectionName)
		return false;
	}	

	@Override
	public List<E> find(Query query) {
		return mongoTemplate.find(query, entityClass);
	}
	
	@Override
	public E findOne(long id) {
		return null;
	}

	@Override
	public List<E> findAll() {
		return null;
	}

	@Override
	public void findAndModify(E query, E modify) {
		
	}

	@Override
	public long total() {
		return 0;
	}
	
	@Override
	public long total(Query query) {
		return mongoTemplate.count(query, entityClass);
	}
	
	@Override
	public List<E> findIn(List<Long> ids) {
		return null;
	}

	@Override
	public List<E> findIn(String fieldName, List<String> list) {
		return null;
	}
	
	@Override
	public boolean insert(E element) {
		mongoTemplate.insert(element);
		return true;
	}	
	
	@Override
	public Paging<E> pagingQuery(Query query, int page, int size) {
		Paging<E> p = new Paging<E>();
		if(page <= 0){
			page = 1;
		}
		
		if(query == null){
			query = new Query();
		}
		query.limit(size).skip((page - 1) * size);
		List<E> rows = (List<E>)mongoTemplate.find(query,entityClass);
		int total = (int) total(query);
		p.setTotal(total);
		p.setRows(rows);
		return p;
	}
	
	@Override
	public void remove(Query query) {
		mongoTemplate.remove(query, entityClass);
	}
	
	@Override
	public void removeOne(long id) {
		mongoTemplate.remove(new Query(Criteria.where(PK).is(id)), entityClass);	
	}

	@Override
	public void removeAll() {
		mongoTemplate.remove(new Query(), entityClass);		
	}
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
