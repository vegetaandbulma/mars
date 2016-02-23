package com.nagao.mars.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagao.db.common.Paging;
import com.nagao.db.nosql.dao.PaperDao;
import com.nagao.framework.data.Paged;
import com.nagao.mars.converter.DocumentConverter;
import com.nagao.mars.domian.vo.Document;
import com.nagao.mars.service.DocService;

@Service("docService")
public class DocServiceImpl implements DocService {
	
	@Autowired
	private PaperDao paperDao;

	@Override
	public boolean addDoc(Document doc) {
		com.nagao.db.nosql.po.Paper paper =new com.nagao.db.nosql.po.Paper();
		paper.setTitle(doc.getTitle());
		paper.setContent(doc.getContent());
		paper.setCreateDate(new Date());
		return paperDao.insert(paper);		
	}

	@Override
	public Paged<Document> pagingQuery(int page, int size, Date from, Date to) {
		Paged<Document> p = new Paged<Document>();
		Paging<com.nagao.db.nosql.po.Paper> paging = paperDao.pagingQuery(null, page, size);
		p.setTotal(paging.getTotal());
		p.setRows(DocumentConverter.batch(paging.getRows()));
		return p;
	}

}
