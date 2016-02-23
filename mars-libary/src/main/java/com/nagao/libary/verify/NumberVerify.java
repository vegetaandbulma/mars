package com.nagao.libary.verify;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberVerify {
	
	public static boolean verifyIsNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static Double formatDouble(Double num, int leaveFloat) {

		BigDecimal b = new BigDecimal(num);
		double f1 = b.setScale(leaveFloat, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;

	}

	/**
	 * 保留两位小数
	 * 
	 * @param amount
	 * @return
	 */
	public static Double get2Decimal(Double amount) {
		if (amount == null
				|| !NumberVerify.verifyIsNumber(String.valueOf(amount))) {
			return 0d;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.parseDouble(df.format(amount));
	}

}
