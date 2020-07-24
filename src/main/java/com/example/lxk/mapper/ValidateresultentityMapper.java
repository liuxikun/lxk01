package com.example.lxk.mapper;

import java.util.List;

import com.example.lxk.entity.QueryConditionForExcleDownLoad;
import com.example.lxk.model.Validateresultentity;



public interface ValidateresultentityMapper {
	
	//20200720添加方法
	int selectMaxNumber(String configId);
	
	int selectTotalDataNumber(String configId);
	
    int insert(Validateresultentity record);
    
    int insertBath(List<Validateresultentity> validateresultentityList);

    int insertSelective(Validateresultentity record);
    
    List<Validateresultentity> findDataByConfigId(QueryConditionForExcleDownLoad queryConditionForExcleDownLoad);
    
    List<Validateresultentity> findDataByCondition(String configId);
    
    List<String> returnDataListByConfigId(String configId);
}