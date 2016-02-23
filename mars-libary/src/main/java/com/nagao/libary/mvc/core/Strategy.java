package com.nagao.libary.mvc.core;

public interface Strategy<D extends BaseBean> {
	public void execute(Transporter transporter,Callback callback);
}
