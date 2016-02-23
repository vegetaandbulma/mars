package com.nagao.libary.mvc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GatewayProxy implements InvocationHandler {

	private Object target;

	/**
	 * 委托对象并返回一个代理类
	 * 
	 * @param target
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		// 取得代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{target.getClass()}, this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("Game Start！");
		result = method.invoke(target, args);
		System.out.println("Game Over！");
		return result;
	}

}
