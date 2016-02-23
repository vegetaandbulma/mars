package com.nagao.patchup;

import java.io.File;
import java.io.FilenameFilter;

public class ClassNameFilter implements FilenameFilter {
	
	private String f;
	
	public ClassNameFilter(String f){
		this.f = f;
	}
	
	public boolean accept(File dir, String name) {
		if(name.indexOf(f) >= 0){
//			System.out.println("accept dir:" + dir);
//			System.out.println("accept name:" + name);
//			System.out.println("accept f:" + f + "  " +name.indexOf(f));
			return true;
		}
		return false;
	}

}
