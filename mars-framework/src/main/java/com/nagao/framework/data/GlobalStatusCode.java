package com.nagao.framework.data;
/**
 * 
 * @author nadonghua
 *
 */
public enum GlobalStatusCode implements IStatusCode {

	SUCCESS("0x0000", "state.success"),//成功	
	FAILURE("0x0001", "state.failure"),
	SESSION_TIME_OUT("0x0002", "state.session.time.out");
	/**
	 * 状态码
	 */
	private String state;
	/**
	 * 对应的key
	 */
	private String key;
	
	private GlobalStatusCode(String state, String key) {
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
