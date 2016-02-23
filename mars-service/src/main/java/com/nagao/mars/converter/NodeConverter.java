package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagao.db.mysql.po.Tree;
import com.nagao.mars.domian.vo.Category;
import com.nagao.mars.domian.vo.Node;

public class NodeConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Node converter(com.nagao.db.mysql.po.Tree tree){
		Node node = new Node();
		node.setId(tree.getId());
		node.setText(tree.getName());
		node.setState("closed");
		Map<String,String> attributes = new HashMap<String,String>();
		attributes.put("url", tree.getUrl());
		attributes.put("root", tree.getRoot());
		attributes.put("code", tree.getCode());
		node.setAttributes(attributes);
		return node;
	}
	
	public static Category converterCategory(com.nagao.db.mysql.po.Tree tree){
		Category category = new Category();
		category.setId(tree.getId());
		category.setName(tree.getName());
		category.setRoot(tree.getRoot());
		category.setCode(tree.getCode());
		category.setCreateDate(format.format(tree.getCreateDate()));
		category.setUrl(tree.getUrl());
		return category;
	}
	
	public static List<Node> batch(List<com.nagao.db.mysql.po.Tree> trees){
		List<Node> ls = new ArrayList<Node>();
		if(trees!=null&&trees.size() >0){
			for(Tree t:trees){		
				ls.add(NodeConverter.converter(t));
			}
		}
		return ls;
	}
}
