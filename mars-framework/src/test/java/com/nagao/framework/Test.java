package com.nagao.framework;

import java.util.HashMap;
import java.util.Map;

import com.nagao.framework.http.HttpWorker;

public class Test {

	public static void main(String[] args) {
		Map<String, String> param = new HashMap<String, String>();
		HttpWorker.worker(true, "http://www.baidu.com", param, "utf-8");
	}

}
