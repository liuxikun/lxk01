package com.example.lxk.service;


import java.util.Date;
import java.util.List;

import com.example.lxk.entity.OptionRecord;
import com.example.lxk.entity.QueryCondition;
import com.example.lxk.model.Config;


public interface ConfigService {
	
	//保存配置，第一次设置保存
	public void saveConfig(Config config) throws Exception;
	
	//查询配置，用户选择之前保存过的配置
	public Config queryConfig(String configId);
	
	public Config queryConfigByUserId(String configId);
	public Config queryUserConfigByGMT(String userId, Date saveTime, Date saveTimeEnd);
	
	public String queryConfigIdByUserId(String userId);
	
	//用户修改配置
	public void updateConfig(Config config) throws Exception;
	
	//查询操作设备记录-保存历史数据次数
	public List<OptionRecord> queryOption(QueryCondition queryCondition) throws Exception;

}
