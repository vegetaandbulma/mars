package com.nagao.db.mysql.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.nagao.db.common.Paging;

public abstract class GenericDAO <T extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements IDao<T, PK > {
	private static Logger log = LoggerFactory.getLogger(GenericDAO.class);
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sf;

	@PostConstruct
	protected void injectSessionFactory() {
		super.setSessionFactory(sf);
	}
	
	@Override
	public T save(T entity) {
		getTemplate().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getTemplate().delete(entity);
	}

	@Override
	public List<T> findAll(Class<T> entityClass) {
		getHibernateTemplate().loadAll(entityClass);
		return null;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(String hql, Map<String, Object> values) {
		Query query = this.createQuery(hql, values);
		return (T)query.uniqueResult();
	}
	
	@Override
	public T get(Class<T> aClass, PK id) {
		return getTemplate().get(aClass, id);
	}
	
	@Override
	public int update(String hsql) {
		Query query = createQuery(hsql, null);
		return query.executeUpdate();
	}

	@Override
	public int update(String hsql, Map<String, Object> params) {
		Query query = createQuery(hsql, params);
		return query.executeUpdate();
	}
	
	@Override
	public HibernateTemplate getTemplate() {
		return this.getHibernateTemplate();
	}
	
	@SuppressWarnings("unchecked")
	@Override	
    public Paging<T> pagingQuery(String hql,Map<String,Object> values,int page,int size) {
    	Paging<T> paging = new Paging<T>();
    	Query query = sf.getCurrentSession().createQuery(hql);
    	if(page > 0 && size > 0){
    		query.setFirstResult((page-1) * size);
            query.setMaxResults(size);
    	}        
        if(values == null){
        	values = new HashMap<String,Object>();
        }
        Set<String> keys = values.keySet();
        for (Object o : keys) {
        	query.setParameter((String)o, values.get(o));
        }
        
        long total = getCount(hql, values);  //总记录条数
        paging.setTotal((int)total);
        List<T> rows = (List<T>) query.list();
        paging.setRows(rows);
        return paging;
    
    }
    
    public long getCount(String hql, Map<String,Object> values) {
    	String countHql = "select count(*) " + hql + " ";       //封装查询总记录条数
        Query query = sf.getCurrentSession().createQuery(countHql);
        Set<String> keys = values.keySet();
        for (Object o : keys) {
            query.setParameter((String)o, values.get(o));
        }
        return (Long)query.uniqueResult();
    }
    
	public Query createQuery(String hsql, Map<String, Object> params) {
		// 取得当前查询总记录数
		Query q = this.getSessionFactory().getCurrentSession()
				.createQuery(hsql);

		String[] keys = q.getNamedParameters();
		if (keys != null && params != null) {
			for (String key : keys) {
				if (!params.containsKey(key)) {
					throw new RuntimeException("没有设置参数" + key + "的值");
				}
				Object value = params.get(key);
				int flg = getParameterType(value);
				switch (flg) {
				case 0:
					q.setParameter(key, value);
					break;
				case 1:
					q.setParameterList(key, (Collection) value);
					break;
				case 2:
					q.setParameterList(key, (Object[]) value);
					break;
				}
			}
		}
		return q;
	}
    	
	private int getParameterType(Object param) {
		if (param == null)
			return 0;
		if (param.getClass().isArray())
			return 2;
		if (param instanceof Collection) {
			return 1;
		}
//		Class[] clss = param.getClass().getInterfaces();
//		if (clss == null)
//			return 0;
//		for (Class cls : clss) {
//			if (cls == Collection.class)
//				return 1;
//		}
		return 0;
	}

}
