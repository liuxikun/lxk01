package com.example.lxk.entity;

import java.time.LocalDateTime;

public class QueryConditionForReportDownload {
	private String configIdNoTimeString;
	private LocalDateTime gmt;
	public String getConfigIdNoTimeString() {
		return configIdNoTimeString;
	}
	public void setConfigIdNoTimeString(String configIdNoTimeString) {
		this.configIdNoTimeString = configIdNoTimeString;
	}
	public LocalDateTime getGmt() {
		return gmt;
	}
	public void setGmt(LocalDateTime gmt) {
		this.gmt = gmt;
	}

}
