package com.example.lxk.vo;

/*
 * 比数据库类少2个字段:创建时间;校验结果
 */
public class ValidateresultentityVo {
	private String pointNum;
    private String inputValue;
    private String realTimePre;
    private String outputValue;
    
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

	//20200418新增属性
    private String validate_result_one;//通道1校验结果
    private String validate_result_two;//通道2校验结果
    private String channelOne;//通道1电流
    private String channelTwo;//通道2电流
    private String error1;  //通道1误差
    private String error2;  //通道2误差



	public String getValidate_result_one() {
		return validate_result_one;
	}

	public void setValidate_result_one(String validate_result_one) {
		this.validate_result_one = validate_result_one;
	}

	public String getValidate_result_two() {
		return validate_result_two;
	}

	public void setValidate_result_two(String validate_result_two) {
		this.validate_result_two = validate_result_two;
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

}
