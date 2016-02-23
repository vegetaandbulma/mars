package com.nagao.patchup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nagao.patchup.bean.JavaCode;
import com.nagao.patchup.bean.Project;
import com.nagao.patchup.config.SystemConfig;
import com.nagao.patchup.load.ReadMavenProject;
import com.nagao.patchup.load.ReadProject;

public class Worker {
	public static final Logger logger = LoggerFactory.getLogger(Worker.class);
	private List<Project> projects = new ArrayList<Project>();
	private List<Object> projectPath;
	private String filepath;
	private List<JavaCode> classlist;
	private String outDir;
	
	public void work(){
		//取出最新的class列表
		List<HierarchicalConfiguration> appList = SystemConfig.getInstance().configurationsAt("apps.app");
		for (Iterator<HierarchicalConfiguration> iterator = appList.iterator(); iterator.hasNext();) {
			HierarchicalConfiguration hierarchicalConfiguration = iterator.next();
			filepath = hierarchicalConfiguration.getString("[@classlist]");
			projectPath = hierarchicalConfiguration.getList("projectPath");
			outDir = hierarchicalConfiguration.getString("out_dir");
		}
		loadJavaClass();
		ReadProject readProject = new ReadMavenProject();
		logger.info("              start                " );
		logger.info("      打包配置文件：    config.xml");
		logger.info("      类名配置文件：    " + filepath );
		logger.info("      扫描的项目路径，注意项目一定要是编译完成的!!!,否则不可能找到编译文件!!!    " );
		for(Object s:projectPath){
			logger.info("projectPath:" + s);
			projects.addAll(readProject.load((String)s));
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.findJavaClass();
		this.packing();
		logger.info("          " );
		logger.info("          " );logger.info("日期 " +  sdf.format(new Date()));
		logger.info("输出 打包日志：" );
		for(JavaCode javaCode:classlist){
			logger.info("-------------------------------------------------------");
			String name = javaCode.getProject()==null ? "":javaCode.getProject().getNamespace();
			logger.info("类 : [" + javaCode.getClassname() + "]");
			logger.info("在项目  [" + name + "] 中");
			logger.info("找到编译文件  [" + javaCode.getFinds().size() + "] 个,具体路径如下：");
			for(String s:javaCode.getFinds()){
				logger.info("  " + s);
			}
			logger.info("Copy到目录:  [" + javaCode.getOutClasspath() + "] 中");
			logger.info("-------------------------------------------------------");
		}
		logger.info("      end    " );
		
	}
	
	public void loadJavaClass(){
		List<String> lines = null;
		File patchFile = new File(Thread.currentThread().getContextClassLoader().getResource(filepath).getFile());
		try {
			lines = FileUtils.readLines(patchFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		classlist = new ArrayList<JavaCode>();
		if(lines!=null){
			for(String c:lines){
				if(c !=null && c.length() > 0){
					JavaCode sourceCode = new JavaCode();
					sourceCode.setClassname(c);
					String temp[] = c.split("\\.");
					if(temp.length >= 3){
						sourceCode.setFilename(temp[temp.length-2] + "." + temp[temp.length-1]);
						sourceCode.setClasspath(c.replace(sourceCode.getFilename(), ""));
						sourceCode.setClasspath(sourceCode.getClasspath().replaceAll("\\.", "/"));
					} else {
						sourceCode.setClasspath(temp[0].substring(0, temp[0].lastIndexOf("/") + 1));
						sourceCode.setFilename(temp[0].substring(temp[0].lastIndexOf("/") + 1) + "." + temp[1]);
					}
					classlist.add(sourceCode);
				}
			}
		}
	}
	
	public void findJavaClass(){
		for(JavaCode javaCode:classlist){
			findJavaClassFromProject(javaCode, projects);
		}
	}
	
	public List<String> findJavaClassFromProject(JavaCode javaCode,List<Project> projects){
		List<String> ls =  new ArrayList<String>();
		if(projects!=null){
			for(Project project:projects){
				String dir = project.getPath() + File.separator + project.getClasspath() + File.separator + javaCode.getClasspath();
				
				File path = new File(dir);
				String file = javaCode.getFilename().replace(".java", "");
				String f[] = path.list(new ClassNameFilter(file));
				if(f!=null && f.length > 0){
					javaCode.setProject(project);
					for(String s:f){
						javaCode.getFinds().add(path + File.separator + s);
					}
				}
				if(project.getSubProject()!=null){
					ls.addAll(findJavaClassFromProject(javaCode, project.getSubProject()));
				}
			}
		}
		return ls;
	}
	
	public void packing(){
		try {
			//清理输出文件目录
			File file = new File(outDir);
			if(file.exists()){
				FileUtils.cleanDirectory(new File(outDir));
			}
			FileUtils.forceMkdir(new File(outDir));
			for(JavaCode javaCode:classlist){
				Project project = javaCode.getProject();
				if(project!=null){
					String d = "";
					if(project.getPackaging()!=null && "jar".equals(project.getPackaging())){
						d = outDir + project.getNamespace() +"-"+ project.getVersion() +"."+ project.getPackaging();
					} else {
						d = outDir + project.getNamespace() + "/WEB-INF/classes/";
					}
					String desc = d + File.separator + javaCode.getClasspath();
					FileUtils.forceMkdir(new File(d));
					FileUtils.forceMkdir(new File(desc));
					javaCode.setOutClasspath(desc);
					
					for(String s:javaCode.getFinds()){
						File compileFile = new File(s);
						if(compileFile.exists()){
							FileUtils.copyFile(compileFile, new File(desc + compileFile.getName()));
						}
					}
				}
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker w = new Worker();
		w.work();
//		for(Project project:projects){
//		System.out.println("###### : " + project.getPath());
//		System.out.println("###### : " + project.getNamespace());
//		System.out.println("###### : " + project.getClasspath());
//		System.out.println("###### : " + project.getPackaging());
//		System.out.println("###### : " + project.getVersion());
//		if(project.getSubProject()!=null && project.getSubProject().size() > 0){
//			for(Project p:project.getSubProject()){
//				System.out.println("1###### : " + p.getPath());
//				System.out.println("1###### : " + p.getNamespace());
//				System.out.println("1###### : " + p.getClasspath());
//				System.out.println("1###### : " + p.getPackaging());
//				System.out.println("1###### : " + p.getVersion());
//			}
//		}
//	}
//	
	}

	@Override
	public String toString() {
		return "Worker [projects=" + projects + ", projectPath=" + projectPath + ", outDir=" + outDir + "]";
	}

}
