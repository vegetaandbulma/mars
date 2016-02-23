package com.nagao.mars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.mysql.dao.UserDao;
import com.nagao.framework.data.Result;
import com.nagao.libary.verify.StringVerify;
import com.nagao.mars.converter.UserConverter;
import com.nagao.mars.domian.vo.User;
import com.nagao.mars.service.PassportService;

@Service("passportService")
@Transactional
public class PassportServiceImpl implements PassportService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public Result<User> login(String username,String email,String password,String code){
		com.nagao.db.mysql.po.User user = userDao.loginQuery(username,email);
		Result<User> r =new Result<User>();
		r.setSuccess(false);
		if(user==null){
			r.setSuccess(false);
			r.setMessage("user no found");
			return r;
		}
		if(!StringVerify.verifyNull(password) && password.equals(user.getPassword())){
			r.setObject(UserConverter.converter(user));
			r.setSuccess(true);
			r.setMessage("");
		} else {
			r.setSuccess(false);
			r.setMessage("password is wrong");
		}
		return r;
	}
	
	@Override
	public boolean logout(String username,String email,String password,String code){
		return false;
	}
	
	@Override
	public boolean register(User userVo){
		com.nagao.db.mysql.po.User user = UserConverter.reverse(userVo);
		user = userDao.save(user);
		if(user !=null){
			return true;
		} else {
			return false;
		}
	}
	
}
