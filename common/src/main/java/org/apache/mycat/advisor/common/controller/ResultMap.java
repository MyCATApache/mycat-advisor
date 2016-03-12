package org.apache.mycat.advisor.common.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultMap extends LinkedHashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "flag";

	private static final String DATA = "data";

	private static final String MSG = "msg";

	private static final String CODE = "code";

	/**
	 * 获取是否成功
	 * 
	 * @return
	 */
	public Boolean getSuccess() {
		return (Boolean) this.get(SUCCESS);
	}

	private void setSuccess(Boolean success) {
		this.put(SUCCESS, success);
		this.put(CODE, 0);
	}

	/**
	 * 获取返回数据
	 * 
	 * @return
	 */
	public Object getData() {
		return this.get(DATA);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDataMap() {
		return (Map<String, Object>) this.get(DATA);
	}

	private void setData(Object data) {
		this.put(DATA, data);
	}

	/**
	 * 获取返回消息
	 * 
	 * @return
	 */
	public Object getMsg() {
		return this.get(MSG);
	}

	private void setMsg(Object msg) {
		this.put(MSG, msg);
	}

	/**
	 * 返回结果成功，返回数据为null
	 */
	public void success() {
		this.clear();
		this.setSuccess(true);
		this.setData(new HashMap<String, Object>());
	}

	/**
	 * 返回结果成功，返回数据为data
	 * 
	 * @param data
	 */
	public void success(Object data) {
		this.clear();
		this.setSuccess(true);
		this.setData(data);
	}

	/**
	 * 返回结果失败，返回消息为null
	 */
	public void failure() {
		this.clear();
		this.setSuccess(false);
		this.setMsg(null);
	}

	/**
	 * 返回结果失败，返回消息为msg
	 * 
	 * @param msg
	 */
	public void failure(Object msg) {
		this.clear();
		this.setSuccess(false);
		this.setMsg(msg);
	}

}
