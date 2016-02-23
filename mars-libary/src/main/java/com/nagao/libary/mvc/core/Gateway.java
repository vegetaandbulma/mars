package com.nagao.libary.mvc.core;


public class Gateway {

	private static Gateway INSTANCE = null;

	public static Gateway getInstance() {
		if (INSTANCE == null) {
			synchronized (Gateway.class) {
				if (INSTANCE == null) {
					INSTANCE = new Gateway();
				}
			}
		}
		return INSTANCE;
	}

	public void invoking(Strategy<?> strategy,Transporter transporter,Callback callback) {
		try {
			strategy.execute(transporter,callback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
