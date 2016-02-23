package com.nagao.mars.nosql;

import java.util.Date;

import org.mongodb.morphia.Datastore;

import com.nagao.mars.nosql.common.MongoFactory;
import com.nagao.mars.nosql.dao.FragmentDao;
import com.nagao.mars.nosql.dao.StockDao;
import com.nagao.mars.nosql.domain.Fragment;

public class Test {

	public static void main(String[] args) {
		Datastore ds =MongoFactory.getDatastore("nosql");
		StockDao stockDao =new StockDao(ds);
		FragmentDao fd = new FragmentDao(ds);
		
		for(int i=0;i<100;i++){
			Fragment s = new Fragment();
			s.setContext(i+"");
			s.setCreateDate(new Date());
			s.setTitle("qqqqqq");
			fd.save(s);
		}
	}

}
