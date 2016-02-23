package com.nagao.mars.nosql.dao;

import java.io.Serializable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.nagao.mars.nosql.domain.Fragment;

public class FragmentDao extends BasicDAO<Fragment, Serializable> {

	public FragmentDao(Datastore ds) {
		super(ds);
		
	}

}
