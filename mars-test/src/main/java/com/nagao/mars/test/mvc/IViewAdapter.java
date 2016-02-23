package com.nagao.mars.test.mvc;

public interface IViewAdapter<D> extends IView {
	public abstract void notifyDataChanged(D data, boolean isRefresh);

	public abstract D getData();

	public boolean isEmpty();
}
