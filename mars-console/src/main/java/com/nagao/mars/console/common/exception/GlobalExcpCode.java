package com.nagao.mars.console.common.exception;
/**
 * 
 * @author nadonghua
 *
 */
public enum GlobalExcpCode implements IException {

	SUCCESS("0x0000", "state.success"),//成功
	
	FAILURE("0x0001", "state.failure");	
	/**
	 * 状态码
	 */
	private String state;
	
	/**
	 * 对应的key
	 */
	private String key;
	
	private GlobalExcpCode(String state, String key) {
		this.state = state;
		this.key = key;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
