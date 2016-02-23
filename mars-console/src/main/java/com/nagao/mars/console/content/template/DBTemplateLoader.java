package com.nagao.mars.console.content.template;

import java.io.IOException;
import java.io.Reader;

import freemarker.cache.TemplateLoader;

public class DBTemplateLoader implements TemplateLoader {
	
	////http://www.cnblogs.com/nixil/archive/2012/04/23/2466364.html
	
	public DBTemplateLoader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object findTemplateSource(String name) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getLastModified(Object templateSource) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reader getReader(Object templateSource, String encoding) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		// TODO Auto-generated method stub

	}

}
