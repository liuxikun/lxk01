/**
 * Outsider.com.cn.
 * Copyright (c) 2011-2020 All Rights Reserved.
 */
package com.example.lxk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lxk.exception.ServiceException;
import com.example.lxk.service.ConfigService;
import com.example.lxk.service.DetectReportExportService;



/**
 * 检测报表导出接口
 * @author outsider
 * @version Id: DetectReportExportController.java, v 0.1 2020/1/5 17:05 outsider Exp $$
 */


@RestController
@RequestMapping(value = "/officeBuild")
public class DetectReportExportController {
    @Autowired
    private DetectReportExportService detectReportExportService;
    @Autowired
    public ConfigService onfigService;
    
    private final static Logger log = LoggerFactory.getLogger(DetectReportExportController.class);
    /**
     * 检测报表导出
     * @param response 响应结果
     * @return         返回导出结果
     */

	@CrossOrigin
	@RequestMapping(value = "/reportDownload", method = RequestMethod.GET)
    @ResponseBody
    public void reportDownload(HttpServletResponse response, HttpServletRequest request) {
		log.info("--in function reportDownload--");
        String configId = null;
        try {
            configId = request.getParameter("configId");
            log.info("--in function downloadXML--" + configId);
            detectReportExportService.reportDownload(response, configId);
        } catch (ServiceException e) {
            log.error("{}检测报表导出接口异常: {}", e);
        } catch (Exception e) {
            log.error("{}检测报表导出系统异常: {}", e);
        }
    }
	
	@CrossOrigin
    @RequestMapping(value = "/reportChannelTwoDownload", method = RequestMethod.GET)
    @ResponseBody
    public void reportChannelTwoDownload(HttpServletResponse response, HttpServletRequest request) {
        System.out.println("--reportChannelTwoDownload--");
        String configId = null;
        try {
            configId = request.getParameter("configId");
            log.info("--in function reportChannelTwoDownload--" + configId);
            detectReportExportService.reportTwoDownload(response, configId);
        } catch (ServiceException e) {
            log.error("{}检测报表导出接口异常: {}", e);

        } catch (Exception e) {
            log.error("{}检测报表导出系统异常: {}", e);
        }
    }
	
	@CrossOrigin
    @RequestMapping(value = "/autoReportDownload", method = RequestMethod.GET)
    @ResponseBody
    public void autoReportDownload(HttpServletResponse response, HttpServletRequest request) {
        String configId = null;
        try {
            configId = request.getParameter("configId");
            log.info("--in function autoReportDownload--" + configId);
            detectReportExportService.reportDownload(response, configId);
        } catch (ServiceException e) {
            log.error("{}检测报表导出接口异常: {}", e);

        } catch (Exception e) {
            log.error("{}检测报表导出系统异常: {}", e);
        }
    }
	
	@CrossOrigin
    @RequestMapping(value = "/autoReportTwoDownload", method = RequestMethod.GET)
    @ResponseBody
    public void autoReportChannelTwoDownload(HttpServletResponse response, HttpServletRequest request) {
        String configId = null;
        try {
            configId = request.getParameter("configId");
            log.info("--in function autoReportChannelTwoDownload--" + configId);
            detectReportExportService.reportTwoDownload(response, configId);
        } catch (ServiceException e) {
            log.error("{}检测报表导出接口异常: {}", e);
        } catch (Exception e) {
            log.error("{}检测报表导出系统异常: {}", e);
        }
    }
}