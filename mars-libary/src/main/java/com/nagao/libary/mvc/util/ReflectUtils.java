package com.nagao.libary.mvc.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import com.nagao.libary.mvc.annotation.EventHandlers;
import com.nagao.libary.mvc.annotation.Mark;

/**
 * 
 * @author nadonghua
 *
 */
public class ReflectUtils {
	public static Set<Method> findMethods(Object o,Class annotation){
		Class c = o.getClass();
		
		 System.out.println(c.getAnnotation(EventHandlers.class).toString() );
		Set<Method> methods = new HashSet<Method>();
		Method[] ms = c.getDeclaredMethods();
		for(Method m:ms){
			if(m.isAnnotationPresent(annotation)){
				System.out.println("[name]:" + m.getName());
				System.out.println("[    ]:" + m.getModifiers());
				System.out.println("[----]:" + m.getAnnotations().toString());
				System.out.println("[    ]:" + m.getModifiers());
				methods.add(m);
			};
		}
		return methods;
	}
	
	public static int findMark(Object o){
		Class<? extends Object> c = o.getClass();
		Mark mark = (Mark)c.getAnnotation(Mark.class);
		return mark.value();
	};
}
