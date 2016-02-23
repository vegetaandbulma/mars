package com.nagao.framework.cache.memcache;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nagao.framework.cache.ICache;

/**
 * memcache 管理类
 * @author donghuana
 *
 */
public class MemCacheManager implements ICache {
	private static Log log = LogFactory.getLog(MemCacheManager.class);

	private MemcachedClient memcachedClient;
	private static boolean power = true;

	public MemCacheManager() {
		// TODO 自动生成的构造函数存根

	}

	private String key(String key, String namespace) {
		return namespace + "_" + key;
	}

	@Override
	public boolean setCache(String key, String namespace, Object value,	int expire) {
		String ck = key(key, namespace);
		try {
			memcachedClient.add(ck, expire, value);
		} catch (Exception e) {
			log.error("addCache error key-> " + ck);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Object getCache(String key, String namespace) {
		String ck = key(key, namespace);
		try {
			return memcachedClient.get(ck);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("addCache error key-> " + ck);
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCache(String key, String namespace) {
		String ck = key(key, namespace);
		try {
			memcachedClient.delete(ck);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("deleteCache error key-> " + ck);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public long increment(String key, String namespace, int by,
			long defaultValue, int expire) {
		String ck = key(key, namespace);
		try {
			return memcachedClient.incr(ck, by, defaultValue, expire);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("increment error key-> " + ck);
			e.printStackTrace();
		}
		return 0;
	}

	public long increment(String key, String namespace, int by) {
		String ck = key(key, namespace);
		try {
			return memcachedClient.incr(ck, by);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("increment error key-> " + ck);
			e.printStackTrace();
		}
		return 0;
	}

	public long decrement(String key, String namespace, int by,
			long defaultValue, int expire) {
		String ck = key(key, namespace);
		try {
			return memcachedClient.decr(ck, by, defaultValue, expire);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("decrement error key-> " + ck);
			e.printStackTrace();
		}
		return 0;
	}

	public long decrement(String key, String namespace, int by) {
		String ck = key(key, namespace);
		try {
			return memcachedClient.decr(ck, by);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块

			log.error("decrement error key-> " + ck);
			e.printStackTrace();
		}
		return 0;
	}

	/*******************************************************************************************************************/

	public MemcachedClient getMemcachedClient() {
		return memcachedClient;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public static boolean isPower() {
		return power;
	}

	public static void setPower(boolean power) {
		MemCacheManager.power = power;
	}
}
