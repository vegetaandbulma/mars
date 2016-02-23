package com.nagao.mars.console.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author nadonghua
 *
 */
public class CookieUtils {

	public static void addCookie(String name, String value, String domain,int maxage, HttpServletResponse response) {
		addCookie(name, value, domain, maxage, "/", response);
	}

	public static void addCookie(String name, String value, String domain,int maxage, String path, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		cookie.setMaxAge(maxage);
		cookie.setPath(path);
		response.addCookie(cookie);
	}

	/**
	 * 从cookie值返回cookie值，如果没有返回 null
	 * 
	 * @param req
	 * @param name
	 * @return cookie的值
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				return cookies[i].getValue();
			}
		}
		return null;
	}

	public static void removeCookie(String name, String domain,HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = new Cookie(name, null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				cookie.setDomain(domain);
				response.addCookie(cookie);
			}
		}
	}

}
