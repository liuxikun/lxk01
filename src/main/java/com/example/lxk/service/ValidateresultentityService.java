package com.example.lxk.service;

import java.util.List;

import com.example.lxk.model.Validateresultentity;
import com.example.lxk.vo.ValidateresultentityVo;


public interface ValidateresultentityService {
	
	public int findLengthForOneOperation(String configId);
	
	public int findTotalDataNumber(String configId);
	
	public void insertValidateresultentity(List<Validateresultentity> entityVoList) throws Exception;
	
	public List<Validateresultentity> queryValidateresultentity(String configId,String gmtCreate);
	
	public List<Validateresultentity> queryValidateresultentityByCondition(String configId, String version);
	
	public List<Validateresultentity> queryValidateresultentityForAutoMode(String configId);
	
	public List<String> returnDataListByConfigId(String configId);

}
