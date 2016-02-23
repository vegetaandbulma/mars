package com.nagao.db.nosql.dao;

import org.springframework.stereotype.Repository;

import com.nagao.db.nosql.common.BaseDao;
import com.nagao.db.nosql.po.Item;

@Repository
public class ItemDao extends BaseDao<Item> {
	public ItemDao(){
		super(Item.class);
	}
}
