package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.Tag;

public interface TagService {
	public boolean addTag(Tag tag);
	public Paged<Tag> pagingQuery(int page,int size,Date from,Date to);	
}
