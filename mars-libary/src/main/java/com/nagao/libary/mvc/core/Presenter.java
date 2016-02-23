package com.nagao.libary.mvc.core;

public interface Presenter {
	public int getId();
	public void refresh();
	public void setUIComponent(UIComponent component);
	public void setModel(Model model);
}
