//package com.nagao.mars.console.common.session.impl;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.nagao.framework.data.Const;
//import com.nagao.framework.utils.CookieUtil;
//import com.nagao.mars.console.common.session.ISessionManager;
//import com.nagao.mars.vo.User;
//
//
//public class SessionManager implements ISessionManager {
//	
//    @Autowired
//    private HttpSession session;
//    
//	@Override
//	public User getUser(HttpServletRequest request) {
//		// TODO 自动生成的方法存根
//		Cookie cookie = CookieUtil.getCookie(request, Const.COOKIE_SESSION);
//		if(cookie != null){
//			return null;
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public void setUser(User u,HttpServletResponse response) {
//		// TODO 自动生成的方法存根
//	//	cacheObjectDao.addCacheObject("U_" + u.getUserId(), u,60 * 1000);
//		CookieUtil.addCookie(response, Const.COOKIE_SESSION, u.getUserId(), 60 * 60 * 2);
//	}
//	
//	@Override
//	public void setVerifyCode(String code) {
//		// TODO 自动生成的方法存根
//		session.setAttribute(Const.VERIFY_CODE_SESSION_KEY, code);
//	}
//
//	@Override
//	public String getVerifyCode() {
//		// TODO 自动生成的方法存根
//		return (String)session.getAttribute(Const.VERIFY_CODE_SESSION_KEY);
//	}
//	
//	@Override
//	public String getUrl() {
//		// TODO 自动生成的方法存根
//		return "";
//	}
//
//	@Override
//	public void setUrl(String url) {
//		// TODO 自动生成的方法存根
//		
//	}
//
//	@Override
//	public void put(String key, Object o) {
//		// TODO 自动生成的方法存根
//		
//	}
//
//	@Override
//	public String get(String key) {
//		// TODO 自动生成的方法存根
//		return null;
//	}
//}
