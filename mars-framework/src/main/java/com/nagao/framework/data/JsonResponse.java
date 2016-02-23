package com.nagao.framework.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类用于 规范化 action 异步 数据输出，各个action 返回的数据 必须由这个类的方法，生成。
 * @author NaOH
 *
 */
public class JsonResponse {
	
	public static Map<String, Object> format(){
		return null;
	}
	
	public static Map<String, Object> format(boolean isSuccess,String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		if(isSuccess){
			result.put(AjaxConst.STATUS, AjaxConst.SUCCESS);
			result.put(AjaxConst.MESSAGE, msg);
		}else{
			result.put(AjaxConst.STATUS, AjaxConst.FAIL);
			result.put(AjaxConst.MESSAGE, msg);
		}
		return result;
	}
	
	public static Map<String, Object> format(boolean isSuccess,Object o,String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		if(isSuccess){
			result.put(AjaxConst.STATUS, AjaxConst.SUCCESS);
			result.put(AjaxConst.DATA, o);
			result.put(AjaxConst.MESSAGE, msg);
		}else{
			result.put(AjaxConst.STATUS, AjaxConst.FAIL);
			result.put(AjaxConst.MESSAGE, msg);
		}
		return result;
	}
	
	public static Map<String, Object> format(boolean isSuccess,int total,List rows,String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		if(isSuccess){
			result.put(AjaxConst.STATUS, AjaxConst.SUCCESS);
			result.put(AjaxConst.TOTAL,total);			
			result.put(AjaxConst.ROWS, rows);
			result.put(AjaxConst.MESSAGE, msg);
		}else{
			result.put(AjaxConst.STATUS, AjaxConst.FAIL);
			result.put(AjaxConst.MESSAGE, msg);
		}
		return result;
	}
	
	public static Map<String, Object> format(boolean isSuccess,String url,String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		if(isSuccess){
			result.put(AjaxConst.STATUS, AjaxConst.SUCCESS);
			result.put(AjaxConst.URL, url);
			result.put(AjaxConst.MESSAGE, msg);
		}else{
			result.put(AjaxConst.STATUS, AjaxConst.FAIL);
			result.put(AjaxConst.MESSAGE, msg);
		}
		return result;
	}	
}
