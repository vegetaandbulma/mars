package com.nagao.framework.data;

import java.io.Serializable;
import java.util.List;

public class Paged<T> implements Serializable {	

	private static final long serialVersionUID = -7569575647850742973L;
	private int total;
	private List<T> rows;
	
	private int size;
	private int page;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

}
