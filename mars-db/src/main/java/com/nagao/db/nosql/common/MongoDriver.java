package com.nagao.db.nosql.common;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDriver {
	private static Logger log = LoggerFactory.getLogger(MongoDriver.class);
	private static Mongo mongo;
	private static DB db;
	private static final String MONGO_DB_ADDRESS = "localhost";
	private static final int MONGO_DB_PORT = 27017;
	private static final String MONGO_DB_USERNAME = "";
	private static final String MONGO_DB_PASSWORD = "";
	//private static final String MONGO_DB_DBNAME = "noseg";
	private static final String MONGO_DB_DBNAME = "no";
	
	private final static MongoDriver instance = new MongoDriver();
	
	static {
        try {
            init();
        } catch (Exception e) {
             log.error("Can't connect MongoDB!");
            e.printStackTrace();
        }
	}
	
	private static void init() {
		try {
			//mongo = new Mongo("192.168.17.28", 27017);  
			mongo = new Mongo(MONGO_DB_ADDRESS, MONGO_DB_PORT);
			db = mongo.getDB(MONGO_DB_DBNAME);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DBCollection getCollection(String collectionName) {
		if(db == null){
			init();
		}
		return db.getCollection(collectionName);
	}
	
	public static MongoDriver getInstance() {
        return instance;
	}

	public static Mongo getMongo() {
		return mongo;
	}

	public static void setMongo(Mongo mongo) {
		MongoDriver.mongo = mongo;
	}

	public static DB getDb() {
		return db;
	}

	public static void setDb(DB db) {
		MongoDriver.db = db;
	}
}
