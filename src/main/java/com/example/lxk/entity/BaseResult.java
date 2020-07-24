package com.example.lxk.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 返回数据实体类
 * 
 * @author zpz
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class BaseResult implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -2719320911606528661L;
	private Integer code;
	private String msg;
	private Object data;
	private Object token;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getToken() {
		return token;
	}

	public void setToken(Object token) {
		this.token = token;
	}

	public BaseResult() {
		super();
	}

	public BaseResult(Integer code, String msg, Object data,Object token) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.token = token;
	}
	public BaseResult(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public BaseResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;

	}
	
}
