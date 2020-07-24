package com.example.lxk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.lxk.mapper.ConfigMapper;
import com.example.lxk.model.Config;
import com.example.lxk.service.TestInterface;


@Service
public class interfaceImpl implements TestInterface {

	@Resource
	ConfigMapper configMapper;
	
	@Override
	public Config queryConfig(String configId) {
		// TODO Auto-generated method stub
		return configMapper.selectByPrimaryKey(configId);
	}
}
