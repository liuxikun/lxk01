package com.example.lxk.mapper;

import java.util.List;

import com.example.lxk.entity.OptionRecord;
import com.example.lxk.entity.QueryCondition;
import com.example.lxk.entity.QueryConditionForReportDownload;
import com.example.lxk.model.Config;



public interface ConfigMapper {
    int deleteByPrimaryKey(String configid)throws Exception;

    int insert(Config record)throws Exception;

    int insertSelective(Config record)throws Exception;

    Config selectByPrimaryKey(String configid);
    
    Config selectConfigByUserId(String userId);
    
    String selectByUserId(String userId);
    
    String selectConfigidByLike(QueryConditionForReportDownload queryConditionForReportDownload);

    int updateByPrimaryKeySelective(Config record)throws Exception;
    
    List<OptionRecord> selectOptionByCondtion(QueryCondition queryCondition)throws Exception;
}