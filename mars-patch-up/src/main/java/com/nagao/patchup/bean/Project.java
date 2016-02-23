package com.nagao.patchup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2176399582310822603L;
	
	private String path;
	private String namespace;
	private String classpath;
	private String version;
	private String packaging;
	private List<String> result;
	private List<String> error;
	private List<Project> subProject =  new ArrayList<Project>();
	
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getClasspath() {
		return classpath;
	}
	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public List<String> getResult() {
		return result;
	}
	public void setResult(List<String> result) {
		this.result = result;
	}
	public List<String> getError() {
		return error;
	}
	public void setError(List<String> error) {
		this.error = error;
	}
	public List<Project> getSubProject() {
		return subProject;
	}
	public void setSubProject(List<Project> subProject) {
		this.subProject = subProject;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Project [path=" + path + ", namespace=" + namespace
				+ ", classpath=" + classpath + ", version=" + version
				+ ", packaging=" + packaging + ", result=" + result
				+ ", error=" + error + ", subProject=" + subProject + "]";
	}
	
	
}
