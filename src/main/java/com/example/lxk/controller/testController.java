package com.example.lxk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.lxk.model.Config;
import com.example.lxk.service.TestInterface;

@RestController
public class testController {

	private final static Logger logger = LoggerFactory.getLogger(testController.class);

	@Autowired
	TestInterface testInterface;

	@RequestMapping("/queryUserConfig")
	public void queryUserConfig() {
		String userId = "123com31234568522";
		logger.info("---testController---" + userId.toString());

		Config config = null;
		try {
			config = testInterface.queryConfig(userId);
			if (config != null) {
				// baseResult.setData(JSON.toJSON(config));
				logger.info("---JSON.toJSON(config)---" + JSON.toJSON(config));
			} else {
				logger.info("---error---");
			}
		} catch (Exception e) {
			logger.info("---Exception---" + e.getMessage());
		}
	}
}
