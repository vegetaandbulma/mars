package com.nagao.db.nosql.common;

import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;

public class MongoFactroy {
	private static Log log = LogFactory.getLog(MongoFactroy.class);
	private static Mongo mongo;
	private DB db;

	private String host;
	private int port = 27017;
	//
	private String dbName;
	//
	private int connectionsPerHost = 15;
	//
	private int threadSize = 10;
	private int maxWaitTime = 3000;
	private int connectTimeout = 15000;
	private int socketTimeout = 15000;
	private boolean autoConnectRetry = true;
	private String user;
	private String password;

	public void init() {
		try {
			mongo = new Mongo(host, 27017);
			MongoOptions opt = mongo.getMongoOptions();
			opt.threadsAllowedToBlockForConnectionMultiplier = threadSize;
			opt.autoConnectRetry = autoConnectRetry;
			opt.connectionsPerHost = connectionsPerHost;
			opt.connectTimeout = connectTimeout;
			opt.socketTimeout = socketTimeout;
			opt.maxWaitTime = maxWaitTime;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		
	}

	private DB getDB() {
		DB db = mongo.getDB(dbName);
		if (user != null && password != null && user.length() > 0 && password.length() > 0) {
			if (db.authenticate(user, password.toCharArray())) {
				return db;
			} else {
				log.error(" need auth !!!");
				return null;
			}
		} else {
			return db;
		}
	}

	public DBCollection getCollection(String collection) {
		DB db = this.getDB();
		if (db != null) {
			return db.getCollection(collection);
		} else {
			return null;
		}
	}

	public void destory() {
		if (mongo != null) {
			mongo.close();
		}
		mongo = null;
		db = null;
	}
	

	/***************************************************************************************************************************************/
	
	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public int getConnectionsPerHost() {
		return connectionsPerHost;
	}

	public void setConnectionsPerHost(int connectionsPerHost) {
		this.connectionsPerHost = connectionsPerHost;
	}

	public int getThreadSize() {
		return threadSize;
	}

	public void setThreadSize(int threadSize) {
		this.threadSize = threadSize;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public boolean getAutoConnectRetry() {
		return autoConnectRetry;
	}

	public void setAutoConnectRetry(boolean autoConnectRetry) {
		this.autoConnectRetry = autoConnectRetry;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
