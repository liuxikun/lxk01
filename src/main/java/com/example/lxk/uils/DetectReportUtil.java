/**
 * Outsider.com.cn.
 * Copyright (c) 2011-2020 All Rights Reserved.
 */
package com.example.lxk.uils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.lxk.entity.PageConstant;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * 检测报表导出工具类
 * 
 * @author outsider
 * @version Id: DetectReportUtil.java, v 0.1 2020/1/5 17:38 outsider Exp $$
 */

@Service
public class DetectReportUtil {
	
	private final static Logger log = LoggerFactory.getLogger(DetectReportUtil.class);
	
	private Configuration configuration = null;

	public DetectReportUtil() {
		configuration = new Configuration();
		configuration.setDefaultEncoding(PageConstant.ENCODE);
	}

	/**
	 * 创建导出的word文件
	 * 
	 * @param dataMap
	 *            生成文件的参数
	 * @param fileName
	 *            导出文件名称
	 * @param response
	 *            返回结果
	 */
	public void reportDownload(Map<String, Object> dataMap, String fileName, HttpServletResponse response) {
		// 需要导出模板的包路径
		configuration.setClassForTemplateLoading(this.getClass(), PageConstant.CLASSPATH);
		Template transmitterTemplate;
		PrintWriter writer = null;
		try {
			log.info("开始生成检测报表");
			// 获取导出文件模板
			transmitterTemplate = configuration.getTemplate(PageConstant.TRANSMITTER_TEMPLATE);
			writer = response.getWriter();
			response.reset();
			// 设置导出文件名称
			fileName = new String(fileName.getBytes("UTF-8"), "iso8859-1") + ".doc";
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setContentType("application/msword");
			// response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			// response.setHeader("Access-Control-Allow-Origin",
			// request.getHeader("Origin"));
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers",
					"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			// 生成导出文件
			transmitterTemplate.process(dataMap, writer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			log.info("检测报表导出X！");
		} catch (TemplateException e) {
			e.printStackTrace();
			log.info("检测报表导出X！");
		} finally {
			if (writer != null) {
				writer.close();
			}
			log.info("文件流关闭成功！");
		}
		log.info("检测报表导出成功！");
	}
	
	public void reportChannelTwoDownload(Map<String, Object> dataMap, String fileName, HttpServletResponse response) {
		// 需要导出模板的包路径
		configuration.setClassForTemplateLoading(this.getClass(), PageConstant.CLASSPATH);
		Template transmitterTemplate;
		PrintWriter writer = null;
		try {
			transmitterTemplate = configuration.getTemplate(PageConstant.TRANSMITTERTWO_TEMPLATE);
			writer = response.getWriter();
			response.reset();
			// 设置导出文件名称
			fileName = new String(fileName.getBytes("UTF-8"), "iso8859-1") + ".doc";
			response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			response.setContentType("application/msword");
			// response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers",
					"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			// 生成导出文件
			transmitterTemplate.process(dataMap, writer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (TemplateException e) {
			e.printStackTrace();
			
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}