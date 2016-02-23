package com.nagao.libary.mvc.core;

import java.util.List;

public interface CommonConnector<T extends BaseBean> {
	public void refresh(List<T> list);
	public void get(T t);
}
