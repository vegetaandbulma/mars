package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagao.db.common.Paging;
import com.nagao.db.mysql.dao.TagDao;
import com.nagao.framework.data.Paged;
import com.nagao.mars.converter.TagConverter;
import com.nagao.mars.domian.vo.Tag;
import com.nagao.mars.service.TagService;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagDao tagDao;

	@Override
	public boolean addTag(Tag tag) {		
		com.nagao.db.mysql.po.Tag t = tagDao.save(TagConverter.reverse(tag));		
		return t!=null ?true:false;
	}

	@Override
	public Paged<Tag> pagingQuery(int page, int size, Date from, Date to) {
		Paged<Tag> p = new Paged<Tag>();
		Paging<com.nagao.db.mysql.po.Tag> paging = tagDao.pagingQuery(page, size, null, null);
		p.setTotal(paging.getTotal());
		p.setRows(TagConverter.batch(paging.getRows()));
		return p;
	}

}
