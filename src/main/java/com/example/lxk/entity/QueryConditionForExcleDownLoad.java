package com.example.lxk.entity;

import java.time.LocalDateTime;

public class QueryConditionForExcleDownLoad {
	private String configId;
	
	private String version;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	private LocalDateTime gmtCreate;
	public String getCondigId() {
		return configId;
	}
	public void setCondigId(String condigId) {
		this.configId = condigId;
	}
	public LocalDateTime getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(LocalDateTime gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}
