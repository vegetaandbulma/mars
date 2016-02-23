package com.nagao.mars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.mysql.dao.MenuDao;
import com.nagao.mars.domian.vo.Menu;
import com.nagao.mars.service.PlatformService;
@Service("platformService")
@Transactional
public class PlatformServiceImpl implements PlatformService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> get(String userId) {
		//menuDao.pagingQuery(page, size, values, order);
		return null;
	}
	
	
}
