package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.User;

public interface UserService {
	public User oneQueryById(String memberId);
	public User oneQueryByMail(String email);
	public User oneQueryByPhone(String phone);
	public Paged<User> pagingQuery(int page,int size,Date from,Date to);	
}
