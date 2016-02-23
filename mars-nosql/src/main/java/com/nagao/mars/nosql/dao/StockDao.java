package com.nagao.mars.nosql.dao;

import java.io.Serializable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.nagao.mars.nosql.domain.Stock;



public class StockDao extends BasicDAO<Stock, Serializable> {	
	public StockDao(Datastore ds){
		super(Stock.class,ds);
	}
}
