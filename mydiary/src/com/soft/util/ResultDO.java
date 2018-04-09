package com.soft.util;

public class ResultDO<T> extends BaseResultDO {
	private T data;

	public ResultDO() {}

	public ResultDO(String key, boolean result) {
		setResultCode(key);
		setSuccess(result);
	}

	public ResultDO(T data) {
		this.data = data;
	}

	public static <T> ResultDO<T> getResult() {
		return new ResultDO<T>();
	}

	public T getModule() {
		return data;
	}

	public void setModule(T data) {
		this.data = data;
	}
}
