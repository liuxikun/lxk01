package com.example.lxk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.lxk.entity.QueryConditionForExcleDownLoad;
import com.example.lxk.mapper.ConfigMapper;
import com.example.lxk.mapper.ValidateresultentityMapper;
import com.example.lxk.model.Validateresultentity;
import com.example.lxk.service.ValidateresultentityService;
import com.example.lxk.vo.ValidateresultentityVo;

@Service
public class ValidateresultentityServiceImpl implements ValidateresultentityService {
	
	@Resource
	ValidateresultentityMapper validateresultentityMapper;
	
	@Resource
	ConfigMapper configMapper;

	@Override
	public void insertValidateresultentity(List<Validateresultentity> entityVoList)
			throws Exception {
		validateresultentityMapper.insertBath(entityVoList);
	}

	@Override
	public List<Validateresultentity> queryValidateresultentity(String configId, String gmtCreate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Validateresultentity> queryValidateresultentityByCondition(String configId, String version) {
		QueryConditionForExcleDownLoad queryConditionForExcleDownLoad = new QueryConditionForExcleDownLoad();
		queryConditionForExcleDownLoad.setVersion(version);
		queryConditionForExcleDownLoad.setCondigId(configId);
		// TODO Auto-generated method stub
		return validateresultentityMapper.findDataByConfigId(queryConditionForExcleDownLoad);
	}

	@Override
	public List<Validateresultentity> queryValidateresultentityForAutoMode(String configId) {
		// TODO Auto-generated method stub
		
		return validateresultentityMapper.findDataByCondition(configId);
	}

	@Override
	public List<String> returnDataListByConfigId(String configId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findLengthForOneOperation(String configId) {
		return validateresultentityMapper.selectMaxNumber(configId);
	}

	@Override
	public int findTotalDataNumber(String configId) {
		// TODO Auto-generated method stub
		return validateresultentityMapper.selectTotalDataNumber(configId);
	}

}
