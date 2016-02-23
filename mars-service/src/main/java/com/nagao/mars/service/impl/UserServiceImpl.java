package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.dao.UserDao;
import com.nagao.framework.data.Paged;
import com.nagao.mars.converter.UserConverter;
import com.nagao.mars.domian.vo.User;
import com.nagao.mars.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Paged<User> pagingQuery(int page, int size, Date from, Date to) {
		Paged<User> paged = new Paged<User>();
		Paging<com.nagao.db.mysql.po.User> p = userDao.pagingQuery(page, size, null, null);
		//Paging<com.nagao.mars.console.db.mysql.po.User> p = userDao.pagingQuery(page, size, null, null);
		paged.setTotal(p.getTotal());
		paged.setRows(UserConverter.batch(p.getRows()));
		return paged;
	}

	@Override
	public User oneQueryById(String UserId) {
		
		return null;
	}

	@Override
	public User oneQueryByMail(String email) {
		
		return null;
	}

	@Override
	public User oneQueryByPhone(String phone) {
		
		return null;
	}
}
