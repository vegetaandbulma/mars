package com.nagao.mars.test.mvc;

public interface IModel<D> {
	// 获取刷新的数据
	public D refresh() throws Exception;

	// 获取加载更多的数据
	public D loadMore() throws Exception;

	// 是否还可以继续加载更多
	public boolean hasMore();
}
