package com.example.lxk.model;

import java.time.LocalDateTime;

public class Validateresultentity {
    private String pointNum;//点序
    private String inputValue;//理论输入
    private String realTimePre;//实际输入数据
    private String outputValue;//理论输出

    public String getPointNum() {
		return pointNum;
	}

	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public String getRealTimePre() {
		return realTimePre;
	}

	public void setRealTimePre(String realTimePre) {
		this.realTimePre = realTimePre;
	}

	public String getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(String outputValue) {
		this.outputValue = outputValue;
	}

	private String configId;//configId
    private LocalDateTime gmtCreate;
    
    private String validateResultOne;//通道1校验结果
    private String validateResultTwo;//通道2校验结果
    private String channelOne;//通道1电流
    private String channelTwo;//通道2电流
    private String error1;  //通道1误差
    private String error2;  //通道2误差

    private String version;
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getValidateResultOne() {
		return validateResultOne;
	}

	public void setValidateResultOne(String validateResultOne) {
		this.validateResultOne = validateResultOne;
	}

	public String getValidateResultTwo() {
		return validateResultTwo;
	}

	public void setValidateResultTwo(String validateResultTwo) {
		this.validateResultTwo = validateResultTwo;
	}

	public String getChannelOne() {
		return channelOne;
	}

	public void setChannelOne(String channelOne) {
		this.channelOne = channelOne;
	}

	public String getChannelTwo() {
		return channelTwo;
	}

	public void setChannelTwo(String channelTwo) {
		this.channelTwo = channelTwo;
	}

	public String getError1() {
		return error1;
	}

	public void setError1(String error1) {
		this.error1 = error1;
	}

	public String getError2() {
		return error2;
	}

	public void setError2(String error2) {
		this.error2 = error2;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public LocalDateTime getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(LocalDateTime gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "Validateresultentity [pointNum=" + pointNum + ", inputValue=" + inputValue + ", realTimePre="
				+ realTimePre + ", outputValue=" + outputValue + ", configId=" + configId + ", gmtCreate=" + gmtCreate
				+ ", validateResultOne=" + validateResultOne + ", validateResultTwo=" + validateResultTwo
				+ ", channelOne=" + channelOne + ", channelTwo=" + channelTwo + ", error1=" + error1 + ", error2="
				+ error2 + "]";
	}

    
}