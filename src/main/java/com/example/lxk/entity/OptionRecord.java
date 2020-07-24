package com.example.lxk.entity;

import java.time.LocalDateTime;

public class OptionRecord {
	private String userId;
	private String configId;
	private LocalDateTime gmtCreate;
	private String isChannelTwo;
	private String port;
	
	private String ip;
	private String city;
	private String com;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIsChannelTwo() {
		return isChannelTwo;
	}

	public void setIsChannelTwo(String isChannelTwo) {
		this.isChannelTwo = isChannelTwo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public LocalDateTime getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(LocalDateTime gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}
