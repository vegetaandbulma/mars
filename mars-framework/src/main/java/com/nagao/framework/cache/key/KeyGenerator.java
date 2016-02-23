package com.nagao.framework.cache.key;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class KeyGenerator {
	
	private static Log log = LogFactory.getLog(KeyGenerator.class);
	
	public KeyGenerator() {
	// TODO 自动生成的构造函数存根


	}
	public static String getMD5Key(String source) {
		String key = null;
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'};// 用来将字节转换成 16 进制表示的字符

		try{
			java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );
			md.update(source.getBytes());
			byte tmp[] = md.digest();						// MD5 的计算结果是一个 128 位的长整数，// 用字节表示就是 16 个字节

			char str[] = new char[16 * 2];					// 每个字节用 16 进制表示的话，使用两个字符，// 所以表示成 16 进制需要 32 个字符

			int k = 0;										// 表示转换结果中对应的字符位置

			for (int i = 0; i < 16; i++) {					// 从第一个字节开始，对 MD5 的每一个字节 // 转换成 16 进制字符的转换

				byte byte0 = tmp[i];						// 取第 i 个字节

				str[k++] = hexDigits[byte0 >>> 4 & 0xf];	// 取字节中高 4 位的数字转换,// >>> 为逻辑右移，将符号位一起右移

				str[k++] = hexDigits[byte0 & 0xf];			// 取字节中低 4 位的数字转换

			}
			key = new String(str);							// 换后的结果转换为字符串

		}catch( Exception e ){
			e.printStackTrace();
		}
		log.debug(" KeyGenerator  source => " +source + " md5 key =>" + key);
		return key;
	}
	
	
	public static void main(String[] args) {
		String source="摩托车仪表灯亮，行车灯和尾灯不亮。";
		System.out.println(source +"   ===>"+KeyGenerator.getMD5Key(source));
		source ="苏州或周边地区地区 大众 途观 现车哪里有卖？";
		System.out.println(source +"   ===>"+KeyGenerator.getMD5Key(source));
	}
}

