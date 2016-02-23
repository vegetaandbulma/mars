package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.Member;

public interface MemberService {
	public Member oneQueryById(String memberId);
	public Member oneQueryByMail(String email);
	public Member oneQueryByPhone(String phone);
	public Paged<Member> pagingQuery(int page,int size,Date from,Date to);	
}
