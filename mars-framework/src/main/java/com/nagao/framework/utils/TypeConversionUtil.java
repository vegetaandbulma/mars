package com.nagao.framework.utils;
/**
 * 
 * @sohu.auto.nlp
 * @author donghuana
 * 数据类型转换工具
 */
public class TypeConversionUtil {

	
	public static int StringToInt(String s){
		if(s!=null){
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
	
	public static Long StringToLong(String s){
		if(s!=null){
			try {
				return Long.valueOf(s);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Long(0l);
			}
		}
		return new Long(0l);
	}
}
