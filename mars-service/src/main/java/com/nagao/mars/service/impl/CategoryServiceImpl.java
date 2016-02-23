package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.dao.TreeDao;
import com.nagao.db.mysql.po.Tree;
import com.nagao.framework.data.Paged;
import com.nagao.framework.utils.NormUtil;
import com.nagao.mars.converter.NodeConverter;
import com.nagao.mars.domian.vo.Category;
import com.nagao.mars.domian.vo.Node;
import com.nagao.mars.service.CategoryService;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private TreeDao treeDao;
	
	private final static String ROOTCODE = "0000";
	
	@Override
	public boolean addNode(Category category) {
		Tree t = new Tree();
		String code = NormUtil.autoZero((int)treeDao.getTotalTreeNodeCount() + 1,"0000");
		if(!category.getRoot().equals(ROOTCODE)){
			code = category.getRoot() + "-" +code;
		}
		if(code.length() <= 14){//最多三级分类
			t.setCode(code);
			t.setCreateDate(new Date());
			t.setModifyDate(new Date());
			t.setRoot(category.getRoot());
			t.setName(category.getName());
			t.setStatus(0);
			treeDao.save(t);
			return t!=null ?true:false;
		} else {
			return false;
		}
	}

	@Override
	public Category getNode(String id) {		
		Tree t = treeDao.get(Tree.class, id);
		if(t!=null){
			return NodeConverter.converterCategory(t);
		} else {
			return null;
		}
	}
	
	@Override
	public boolean deleteNode(String id) {
		Tree t = treeDao.get(Tree.class, id);
		if(t!=null){
			treeDao.delete(t);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hideNode(String id) {
		if(id !=null && !id.isEmpty()){
			return treeDao.status(id, -1);
		} else {
			return false;
		}		
	}


	@Override
	public boolean modifyNode(Category category) {
		return treeDao.update(category.getId(), category.getName(), category.getUrl(), category.getRoot(), category.getCode());
	}
	
	@Override
	public Paged<Node> pagingQuery(int page, int size, Date from, Date to) {
		Paged<Node> paged = new Paged<Node>();
		Paging<Tree> p = treeDao.pagingQuery(-1, -1, null, null);
		paged.setTotal(p.getTotal());
		paged.setRows(NodeConverter.batch(p.getRows()));
		return paged;
	}

	@Override
	public Paged<Node> getNodes(int page, int size, String id) {
		Paged<Node> paged = new Paged<Node>();
		Tree t =null;
		if(id!=null&&!id.isEmpty()){
			 t = treeDao.get(Tree.class, id);
		} else {
			 t = new Tree();
		}		
		if(t.getCode() == null || t.getCode().isEmpty()){
			t.setCode(ROOTCODE);
		}
		Paging<Tree> p = treeDao.getNodes(page, size, t.getCode(), null);
		paged.setTotal(p.getTotal());
		paged.setRows(NodeConverter.batch(p.getRows()));
		return paged;
	}

}
