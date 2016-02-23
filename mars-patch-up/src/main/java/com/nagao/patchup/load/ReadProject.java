package com.nagao.patchup.load;

import java.util.List;

import com.nagao.patchup.bean.Project;

public interface ReadProject {
	public List<Project> load(String projectpath);
}
