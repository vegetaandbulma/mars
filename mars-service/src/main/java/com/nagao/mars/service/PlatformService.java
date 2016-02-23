package com.nagao.mars.service;

import java.util.List;

import com.nagao.mars.domian.vo.Menu;

public interface PlatformService {
	public List<Menu> get(String userId);
}
