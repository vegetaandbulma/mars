package com.nagao.framework.form;

import java.io.Serializable;
import java.util.List;
/**
 * 分页 工具
 * @author nadonghua
 *
 * @param <T>
 */
public class Paging<T>  implements Serializable {

	private static final long serialVersionUID = 7846221943086101223L;
	
	
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
