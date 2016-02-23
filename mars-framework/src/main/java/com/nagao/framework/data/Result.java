package com.nagao.framework.data;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = -2027722494749050891L;
	
	private boolean isSuccess;
	private String message;
	private Paged<T> paged;
	private T object;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Paged<T> getPaged() {
		return paged;
	}
	public void setPaged(Paged<T> paged) {
		this.paged = paged;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
}
