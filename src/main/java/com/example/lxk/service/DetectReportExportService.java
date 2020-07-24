/**
 * Outsider.com.cn.
 * Copyright (c) 2011-2020 All Rights Reserved.
 */
package com.example.lxk.service;

import javax.servlet.http.HttpServletResponse;

/**
 * 检测报表导出接口
 * @author outsider
 * @version Id: DetectReportExportService.java, v 0.1 2020/1/5 17:28 outsider Exp $$
 */
public interface DetectReportExportService {
    /**
     * 检测报表导出
     */
    void reportDownload(HttpServletResponse response, String configId);
    
    void reportTwoDownload(HttpServletResponse response, String configId);
}