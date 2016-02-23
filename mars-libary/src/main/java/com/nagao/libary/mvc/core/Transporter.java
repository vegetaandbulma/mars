package com.nagao.libary.mvc.core;

import java.util.List;

public interface Transporter {
	public Object getBody();
	public <T extends BaseBean> List<T> get();
	public void set();
}
