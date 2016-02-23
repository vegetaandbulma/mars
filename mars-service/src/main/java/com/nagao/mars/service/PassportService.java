package com.nagao.mars.service;

import com.nagao.framework.data.Result;
import com.nagao.mars.domian.vo.User;

public interface PassportService {
	
	public Result<User> login(String username,String email,String password,String code);
	
	public boolean logout(String username,String email,String password,String code);
	
	public boolean register(User user); 

}
