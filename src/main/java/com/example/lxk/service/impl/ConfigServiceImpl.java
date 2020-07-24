package com.example.lxk.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.example.lxk.entity.OptionRecord;
import com.example.lxk.entity.QueryCondition;
import com.example.lxk.mapper.ConfigMapper;
import com.example.lxk.model.Config;
import com.example.lxk.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {
	
	@Resource
	ConfigMapper configMapper;

	@Override
	public void saveConfig(Config config) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Config queryConfig(String configId) {
		// TODO Auto-generated method stub
		return configMapper.selectByPrimaryKey(configId);
	}

	@Override
	public Config queryConfigByUserId(String configId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Config queryUserConfigByGMT(String userId, Date saveTime, Date saveTimeEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryConfigIdByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateConfig(Config config) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OptionRecord> queryOption(QueryCondition queryCondition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
