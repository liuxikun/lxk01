package com.example.lxk.entity;

/**
 * @author zhangjun
 * @version Id: UserInfoDO.java, v 0.1 2020/1/13 17:04 zhangjun Exp $$
 */

public class DetectionInfoDO {
    /**
     * 点序
     */
    private String pointNo;

    /**
     * 标准输入
     */
    private String standardInput;

    /**
     * 标准输出
     */
    private String standardOutput;

    /**
     * 第一次上升
     */
    private String firstRise;

    /**
     * 第一次上升
     */
    private String firstFall;

    /**
     * 第二次上升
     */
    private String secondRise;

    /**
     * 第二次下降
     */
    private String secondFall;

    /**
     * 第三次上升
     */
    private String thirdRise;

    /**
     * 第三次下降
     */
    private String thirdFall;

    /**
     * 基本误差上升
     */
    private String basicErrorRise;

    /**
     * 基本误差下降
     */
    private String basicErrorFall;

    /**
     * 回差
     */
    private String returnErrors;

	public String getPointNo() {
		return pointNo;
	}

	public void setPointNo(String pointNo) {
		this.pointNo = pointNo;
	}

	public String getStandardInput() {
		return standardInput;
	}

	public void setStandardInput(String standardInput) {
		this.standardInput = standardInput;
	}

	public String getStandardOutput() {
		return standardOutput;
	}

	public void setStandardOutput(String standardOutput) {
		this.standardOutput = standardOutput;
	}

	public String getFirstRise() {
		return firstRise;
	}

	public void setFirstRise(String firstRise) {
		this.firstRise = firstRise;
	}

	public String getFirstFall() {
		return firstFall;
	}

	public void setFirstFall(String firstFall) {
		this.firstFall = firstFall;
	}

	public String getSecondRise() {
		return secondRise;
	}

	public void setSecondRise(String secondRise) {
		this.secondRise = secondRise;
	}

	public String getSecondFall() {
		return secondFall;
	}

	public void setSecondFall(String secondFall) {
		this.secondFall = secondFall;
	}

	public String getThirdRise() {
		return thirdRise;
	}

	public void setThirdRise(String thirdRise) {
		this.thirdRise = thirdRise;
	}

	public String getThirdFall() {
		return thirdFall;
	}

	public void setThirdFall(String thirdFall) {
		this.thirdFall = thirdFall;
	}

	public String getBasicErrorRise() {
		return basicErrorRise;
	}

	public void setBasicErrorRise(String basicErrorRise) {
		this.basicErrorRise = basicErrorRise;
	}

	public String getBasicErrorFall() {
		return basicErrorFall;
	}

	public void setBasicErrorFall(String basicErrorFall) {
		this.basicErrorFall = basicErrorFall;
	}

	public String getReturnErrors() {
		return returnErrors;
	}

	public void setReturnErrors(String returnErrors) {
		this.returnErrors = returnErrors;
	}
    
    
}