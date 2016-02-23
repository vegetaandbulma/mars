package com.nagao.libary.mvc.core;

public interface Callback {
	public void onComplete();
	public void onPrepare();
	public void onError();
	public void onFail();
	public void onSuccess();
}
