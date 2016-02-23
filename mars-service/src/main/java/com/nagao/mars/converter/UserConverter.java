package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagao.mars.domian.vo.User;

public class UserConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static User converter(com.nagao.db.mysql.po.User u){
		User user = new User();
		user.setUserId(u.getId());
		user.setName(u.getUserName());
		user.setEmail(u.getEmail());
		user.setTelephone(u.getTelephone());
		user.setStatus(String.valueOf(u.getStatus()));
		user.setCreateDate(format.format(u.getCreateDate()));
		return user;
	}
	
	public static List<User> batch(List<com.nagao.db.mysql.po.User> us){
		List<User> ls = new ArrayList<User>();
		if(us !=null){
			for(com.nagao.db.mysql.po.User u:us){
				ls.add(UserConverter.converter(u));
			}
		}
		return ls;
	}
	public static com.nagao.db.mysql.po.User reverse(User u){
		com.nagao.db.mysql.po.User user = new com.nagao.db.mysql.po.User();
		user.setUserName(u.getName());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.setTelephone(u.getTelephone());
		user.setModifyDate(new Date());
		user.setCreateDate(new Date());
		return user;
	}
}
