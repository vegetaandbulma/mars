package com.nagao.framework.cache.redis;

import com.nagao.framework.cache.ICache;

public class RedisCacheManager implements ICache {

	@Override
	public boolean setCache(String key, String namespace, Object value,int expire) {
		return false;
	}

	@Override
	public Object getCache(String key, String namespace) {
		return null;
	}

}
