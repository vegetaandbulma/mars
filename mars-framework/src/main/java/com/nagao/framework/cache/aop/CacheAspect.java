package com.nagao.framework.cache.aop;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.nagao.framework.cache.annotation.Cache;
import com.nagao.framework.cache.annotation.CacheKey;
import com.nagao.framework.cache.memcache.MemCacheManager;

/**
 * aop 拦截类，负责拦截 所有 @Cache @Flush 标记的方法
 * @author donghuana
 *
 */
@Aspect
public class CacheAspect {
	private static Log log = LogFactory.getLog(CacheAspect.class);
	private static final Comparator<CacheKey> COMPARATOR = new CacheKeyComparator();
	private final static String cache = "@annotation(com.nagao.framework.cache.annotation.Cache)";

	@Resource(name="defaultCache")  
	private MemCacheManager defaultCache;	


	@Around(cache)
	public Object aroundCache(ProceedingJoinPoint p) {
		log.debug(" ** CacheAspect ** ");
		Object result = null; 
		MethodSignature sig=(MethodSignature)p.getSignature();
		Method method=sig.getMethod();  
		
		 Annotation[][] paramAnnotationArrays =null;
		 Method[] methods = p.getTarget().getClass().getDeclaredMethods();

		Cache cache =p.getTarget().getClass().getAnnotation(Cache.class);
		for(Method m: methods){
			if(m.getName().equals(method.getName())){
				cache = m.getAnnotation(Cache.class);
				paramAnnotationArrays =m.getParameterAnnotations();
				System.out.println("   ======cache===>" +cache.toString());
			}
		}
			
		log.debug(" method ->" + method.getName() + "  => " + cache.toString() + MemCacheManager.isPower());
		if(cache!=null&&MemCacheManager.isPower()){
			long expire= cache.expiration();
			String key = CacheAspect.getParamterKey(paramAnnotationArrays, p.getArgs());			
			result = defaultCache.getCache(key,cache.namespace());
			if(result != null){
				log.debug(" CacheAspect get cache Object namespace = >" + cache.namespace() +"key => " + key );
				return result;
			}else{
				try {
					result = p.proceed();
				} catch (Throwable e) {
					// TODO 自动生成的 catch 块


					e.printStackTrace();
				}
				log.debug(" CacheAspect no cache and addCache Object namespace = >" + cache.namespace() +"key => " + key );
				defaultCache.setCache(key, cache.namespace(),result, (int)expire);
			}	
		}else{
			try {
				log.debug(" CacheAspect Cache power is close");
				result = p.proceed();
			} catch (Throwable e) {
				// TODO 自动生成的 catch 块


				e.printStackTrace();
			}
		}
		return result;		
	}
    
	private static String getParamterKey(Annotation[][] paramAnnotationArrays,Object paramter[]){
		String key ="";
		SortedMap<CacheKey, Integer> orders = new TreeMap<CacheKey, Integer>(COMPARATOR);
		Set<Integer> order = new HashSet<Integer>();
		if (paramAnnotationArrays != null && paramAnnotationArrays.length > 0) {
			CacheKey cacheKey;
			for (int ix = 0; ix < paramAnnotationArrays.length; ix++) {
				cacheKey = getAnnotation(CacheKey.class, paramAnnotationArrays[ix]);
				if(cacheKey!=null){
					// throw if order below 0


					if (cacheKey.order() < 0) {
						log.error(" CacheKey paramter error order < 0 !!!");
						return null;
                    }
                    // throw exception if there are two annotations with the same value of order


                    if (!order.add(cacheKey.order())) {
                    	log.error(" CacheKey paramter error there are two annotations with the same value of order !!!");
            			return null;
                    }
                    orders.put(cacheKey, ix);
				}
			}			
			for(Integer index:orders.values()){
				key = key + paramter[index];
			}			
		}else{
			log.error(" no found CacheKey paramter !!!");
			return null;
		}
		return key;
	}
	
	
	private static <T extends Annotation> T getAnnotation(final Class<T> annotationClass, final Annotation[] annotations) {
        if (annotations != null && annotations.length > 0) {
            for (final Annotation annotation : annotations) {
                if (annotationClass.equals(annotation.annotationType())) {
                    return (T) annotation;
                }
            }
        }
        return null;
    }
	
	
    private static class CacheKeyComparator implements Comparator<CacheKey>, Serializable {
		private static final long serialVersionUID = -5224067763407612877L;
		public int compare(final CacheKey o1, final CacheKey o2) {
            return o1.order() - o2.order();
        }
    }
    
    
    
	
	public MemCacheManager getDefaultCache() {
		return defaultCache;
	}

	public void setDefaultCache(MemCacheManager defaultCache) {
		this.defaultCache = defaultCache;
	}
}
