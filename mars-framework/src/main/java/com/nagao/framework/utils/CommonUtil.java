package com.nagao.framework.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtil {

	public static final boolean isNullStr(String str) {
		if ((str == null) || (str.length() == 0)) {
			return (true);
		}
		return (false);
	}

	public static String getNowTime() {
		Date now = new Date();
		return DateFormat.getDateTimeInstance().format(now);

	}

	public static String getTodayDate(String format) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat(format);
		return df.format(now);
	}

	public static long getId() {
		long result = 0;
		long id = 0;
		String total = "";
		id = System.currentTimeMillis();
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		if (ranNum < 10) {
			total = "" + id + "00" + ranNum;
		} else if (ranNum < 100) {
			total = "" + id + "0" + ranNum;
		} else {
			total = "" + id + ranNum;
		}
		result = Long.parseLong(total);
		return result;
	}

	public static boolean writeBytestoFile(byte[] bytes, String filepath)
			throws Exception {
		boolean ok = true;
		FileOutputStream fos = null;
		try {
			File f = new File(filepath);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			ok = false;
		} finally {
			if (fos != null)
				fos.close();
		}
		return ok;
	}
}
