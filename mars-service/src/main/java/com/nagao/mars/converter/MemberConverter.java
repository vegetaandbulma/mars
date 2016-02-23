package com.nagao.mars.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.nagao.mars.domian.vo.Member;

public class MemberConverter {
	
	private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static Member converter(com.nagao.db.mysql.po.Member m){
		Member member = new Member();
		member.setId(m.getId());
		member.setEmail(m.getEmail());
		member.setName(m.getNickname());
		member.setTelephone(m.getTelephone());
		member.setCreateDate(format.format(m.getCreateDate()));
		return member;
	}
	
	public static List<Member> batch(List<com.nagao.db.mysql.po.Member> ms){
		List<Member> ls = new ArrayList<Member>();
		if(ms !=null){
			for(com.nagao.db.mysql.po.Member m:ms){
				ls.add(MemberConverter.converter(m));
			}
		}
		return ls;
	}
}
