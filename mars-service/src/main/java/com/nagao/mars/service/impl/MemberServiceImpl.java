package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.dao.MemberDao;
import com.nagao.framework.data.Paged;
import com.nagao.mars.converter.MemberConverter;
import com.nagao.mars.domian.vo.Member;
import com.nagao.mars.service.MemberService;


@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Paged<Member> pagingQuery(int page, int size, Date from, Date to) {
		Paged<Member> paged = new Paged<Member>();
		Paging<com.nagao.db.mysql.po.Member> p = memberDao.pagingQuery(page, size, null, null);
		//Paging<com.nagao.mars.console.db.mysql.po.User> p = userDao.pagingQuery(page, size, null, null);
		paged.setTotal(p.getTotal());
		paged.setRows(MemberConverter.batch(p.getRows()));
		return paged;
	}

	@Override
	public Member oneQueryById(String memberId) {
		
		return null;
	}

	@Override
	public Member oneQueryByMail(String email) {
		
		return null;
	}

	@Override
	public Member oneQueryByPhone(String phone) {
		
		return null;
	}
}
