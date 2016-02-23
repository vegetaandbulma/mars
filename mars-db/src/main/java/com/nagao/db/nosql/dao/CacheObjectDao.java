package com.nagao.db.nosql.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.CacheObject;
import com.nagao.db.nosql.utils.SerializeUtil;

@Repository
public class CacheObjectDao extends BaseDao<CacheObject> {
	
	public CacheObjectDao(){
		super(CacheObject.class);
	}
	
	public boolean addCacheObject(String key,Object object){
		return this.addCacheObject(key, object, 0);
	}
	
	public boolean addCacheObject(String key,Object object,long alive){
		CacheObject cacheObject = new CacheObject();
		cacheObject.setKey(key);
		cacheObject.setData(SerializeUtil.serialize(object));
		if(alive > 0){
			cacheObject.setAlive(System.currentTimeMillis() + alive);
		} else {
			cacheObject.setAlive(0);
		}
		this.insert(cacheObject);
		return true;
	}
	
	public Object getCacheObject(String key){
		Query query = new Query();
		query.addCriteria(Criteria.where("key").is(key));
		List<CacheObject> rs = this.find(query);
		if(rs.size()==1){
			CacheObject co = rs.get(0);
			long s = System.currentTimeMillis();
			if(co.getAlive()> 0 && s >= co.getAlive()){
				this.remove(query);
				return null;
			}
			return SerializeUtil.unserialize(co.getData());
		} else {
			return null;
		}	
	}
	
	public boolean removeCacheObject(String key){
		Query query = new Query();
		query.addCriteria(Criteria.where("key").is(key));
		this.remove(query);
		return true;
	}
}
