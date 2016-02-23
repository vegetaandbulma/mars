package com.nagao.mars.service;

import java.util.Date;

import com.nagao.framework.data.Paged;
import com.nagao.mars.domian.vo.Document;

public interface DocService {
	public boolean addDoc(Document doc);
	public Paged<Document> pagingQuery(int page,int size,Date from,Date to);	
}
