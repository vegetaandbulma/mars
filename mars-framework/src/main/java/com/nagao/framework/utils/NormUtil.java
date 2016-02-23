package com.nagao.framework.utils;

public class NormUtil {
	public static String autoZero(int number,String pattern){
		 java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
		 return df.format(number) + "";
	}
}
