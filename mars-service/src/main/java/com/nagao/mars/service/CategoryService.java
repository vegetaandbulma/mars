package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.Category;
import com.nagao.mars.domian.vo.Node;

public interface CategoryService {
	public boolean addNode(Category category);
	public Category getNode(String id);
	public boolean deleteNode(String id);
	public boolean hideNode(String id);
	public boolean modifyNode(Category category);
	public Paged<Node> pagingQuery(int page,int size,Date from,Date to);
	public Paged<Node> getNodes(int page, int size, String code);
}
