package com.nagao.framework.cache;

public interface ICache {
	  public boolean setCache(String key,String namespace,Object value,int expire);	
	  public Object getCache(String key,String namespace);
}
