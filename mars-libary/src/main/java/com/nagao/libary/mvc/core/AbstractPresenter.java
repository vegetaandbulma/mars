package com.nagao.libary.mvc.core;

import com.nagao.libary.mvc.util.ReflectUtils;

public abstract class AbstractPresenter implements Presenter,Callback {
	
	private int id = 0;
	
	private UIComponent component;
	
	private Model model;
	
	private CommonConnector commonConnector;
	
	public AbstractPresenter(UIComponent component){
		this.init();
		this.component = component;
	}
	
	private void init(){
		id = ReflectUtils.findMark(this);
	}

	public int getId() {
		return id;
	}

	public void setUIComponent(UIComponent component) {
		this.component = component;
	}

	public void setModel(Model model) {
		
	}

}
