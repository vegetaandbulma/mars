package com.nagao.patchup.bean;

import java.util.ArrayList;
import java.util.List;

public class JavaCode {
	
	private String classname;
	private String classpath;
	private String filename;
	private Project project;
	private String outClasspath;
	
	private List<String> finds = new ArrayList<String>();
	
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getClasspath() {
		return classpath;
	}
	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<String> getFinds() {
		return finds;
	}
	public void setFinds(List<String> finds) {
		this.finds = finds;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "JavaCode [classname=" + classname + ", classpath=" + classpath
				+ ", filename=" + filename + ", project=" + project
				+ ", finds=" + finds + "]";
	}
	public String getOutClasspath() {
		return outClasspath;
	}
	public void setOutClasspath(String outClasspath) {
		this.outClasspath = outClasspath;
	}
}
