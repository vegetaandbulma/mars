package com.nagao.mars.console.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
	@Autowired  
	public  HttpServletRequest request;
	@Autowired 
	public  HttpServletResponse response;
}
