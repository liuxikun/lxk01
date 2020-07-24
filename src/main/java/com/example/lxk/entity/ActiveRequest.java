package com.example.lxk.entity;

import java.util.List;

import com.example.lxk.vo.ValidateresultentityVo;


public class ActiveRequest {
	private String userId;
	private String configId;
	
	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	private String comNum;
	private List<ValidateresultentityVo> entityList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComNum() {
		return comNum;
	}

	public void setComNum(String comNum) {
		this.comNum = comNum;
	}

	public List<ValidateresultentityVo> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<ValidateresultentityVo> entityList) {
		this.entityList = entityList;
	}


}
