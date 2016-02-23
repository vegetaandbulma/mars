package com.nagao.mars.nosql.common;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoFactory {
	public static Mongo MONGO;

	public static void init() {
		MONGO = new MongoClient(new ServerAddress("127.0.0.1", 27017));
	}

	public static Datastore getDatastore(String dbname) {
		if(MONGO==null){
			init();
		}
		Morphia morphia = new Morphia();
		Datastore ds = morphia.createDatastore((MongoClient) MONGO, dbname);
		return ds;
	}
}
