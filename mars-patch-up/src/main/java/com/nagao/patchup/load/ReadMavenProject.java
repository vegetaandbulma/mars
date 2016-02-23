package com.nagao.patchup.load;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;

import com.nagao.patchup.bean.Project;
import com.nagao.patchup.utils.XMLParser;

public class ReadMavenProject implements ReadProject {

	public List<Project> load(String projectpath) {
		List<Project> ps =  new ArrayList<Project>();
		File path = new File(projectpath);
		if(path.isDirectory()){
			 File[] subpath = path.listFiles();
			 Project project = new Project();
			 for(int i=0;i<subpath.length;i++){
				if(subpath[i].isFile()){
					if(".project".equals(subpath[i].getName())){
						project.setPath(path.getAbsolutePath());
						 XMLParser projectXML = new XMLParser(subpath[i].getPath());
						 Node node = projectXML.getNode("/projectDescription/name");
						 if(node!=null){
							// node.
							// System.out.println("projectXML:" + node.getText());
							 project.setNamespace(node.getText());
						 }
						
						String pompath = path.getPath() + "\\pom.xml"; 
						File pomfile = new File(pompath);
						if(pomfile.exists()){
							//System.out.println(" pompath: " + pompath);
							XMLParser pomXML = new XMLParser(pompath);
							
							Element element = pomXML.getDocument().getRootElement();
							Element version= element.element("version");
							Element packaging= element.element("packaging");
							if(version!=null){
								project.setVersion(version.getText());
								//System.out.println("version:" + version.getText());
							}
							if(packaging!=null){
								project.setPackaging( packaging.getText());
								//System.out.println("packaging:" + packaging.getText());
							}
							
						}
						String classpath = path.getPath() + "\\.classpath"; 
						File classfile = new File(classpath);
						if(classfile.exists()){
							XMLParser classpathXML = new XMLParser(classpath);
							Node node2 = classpathXML.getNode("/classpath/classpathentry[@kind='output']/@path");
							if(node2!=null){
								// node.
								project.setClasspath(node2.getText());
								// System.out.println("classpath:" + node2.toString());
							}
						}
						ps.add(project);
					}
				} else {
					if(project!=null){
						project.getSubProject().addAll(load(subpath[i].getPath()));
					}
				}
			 }
		}
		return ps;
	}

}
