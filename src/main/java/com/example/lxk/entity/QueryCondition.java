package com.example.lxk.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class QueryCondition {
	private String configId;
	private String userId;
	private Integer pageCount;//页数
	private LocalDateTime gmtCreate;
	private LocalDateTime gmtCreateEnd;

	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getGmtCreateEnd() {
		return gmtCreateEnd;
	}
	public void setGmtCreateEnd(LocalDateTime gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
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
