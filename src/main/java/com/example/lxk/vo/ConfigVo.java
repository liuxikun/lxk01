package com.example.lxk.vo;


public class ConfigVo {

	//通道1参数
	private String productType;
	private String productNum;
	private String productFactory;
	private String productGMT;
	private String inputRange;
	private String outputRange;
	private String testPointNum;
	
	//通道2参数
	private String productTypeTwo;
	private String productNumTwo;
	private String productFactoryTwo;
	private String productGMTTwo;
	private String inputRangeTwo;
	private String outputRangeTwo;
	private String testPointNumTwo;
	
	//公共参数
	private String productInputRange; //  --被检表使用范围-输入范围
	private String productOutputRange; // --被检表使用范围-输出范围
	private String productUseSpot;//      --被检表使用场合
	
	private String deviceGenerateType;//     --下位机1类型
	private String deviceGenerateNum;//      --下位机1编号
	private String deviceGenerateLevel;//    --下位机1精度等级

	private String deviceProofType;//        --下位机2类型
	private String deviceProofNum;//         --下位机2编号
	private String deviceProofLevel;//       --下位机2精度等级
	
	private String workProperty;//           --工作性质
	private String temperature;//            --室温
	private String relativeHumidity;//       --相对湿度
	private String region;//                 --区域
	private String managementCategory;//     --管理类别
	private String liquidColumnCorrection;// --液柱修正
	private String certificateNum;//         --证书编号
	private String deviceProofTypeTwo;
	private String configId;
	
    public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	private String com;
    private String city;
    private String ip;
    
	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceProofTypeTwo() {
		return deviceProofTypeTwo;
	}

	public void setDeviceProofTypeTwo(String deviceProofTypeTwo) {
		this.deviceProofTypeTwo = deviceProofTypeTwo;
	}

	private String timeSps;//new id
	private String comNum;
	private String userId;
	
	private String baudrate;//波特率
	private String databits;//数据位
	private String stopbits;//停止位
	private String parity;//校验位
	private String level;
	//输入
    private String inputType;//输入-类型
    private String inputUnit;//输入-单位
    private String inputLine;//输入-线性化
    private String inputHeigh;//输入-高限
    private String inputLow;//输入-低限
    private String isChannelTwo;

    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsChannelTwo() {
		return isChannelTwo;
	}

	public void setIsChannelTwo(String isChannelTwo) {
		this.isChannelTwo = isChannelTwo;
	}

	//输出
    private String outputType;//输出-类型
    private String outputUnit;//输出-单位
    private String outputLine;//输出-线性化
    private String outputHeigh;//输出-高限
    private String outputLow;//输出-底限
    
    private String baseOffSet;//输出-基本偏置
    private String holdTime;//输出-稳压时间
    private String error;//输出-允许误差
    private String returnError;//输出-回差允许值
	

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductFactory() {
		return productFactory;
	}

	public void setProductFactory(String productFactory) {
		this.productFactory = productFactory;
	}

	public String getProductGMT() {
		return productGMT;
	}

	public void setProductGMT(String productGMT) {
		this.productGMT = productGMT;
	}

	public String getInputRange() {
		return inputRange;
	}

	public void setInputRange(String inputRange) {
		this.inputRange = inputRange;
	}

	public String getOutputRange() {
		return outputRange;
	}

	public void setOutputRange(String outputRange) {
		this.outputRange = outputRange;
	}

	public String getTestPointNum() {
		return testPointNum;
	}

	public void setTestPointNum(String testPointNum) {
		this.testPointNum = testPointNum;
	}

	public String getProductTypeTwo() {
		return productTypeTwo;
	}

	public void setProductTypeTwo(String productTypeTwo) {
		this.productTypeTwo = productTypeTwo;
	}

	public String getProductNumTwo() {
		return productNumTwo;
	}

	public void setProductNumTwo(String productNumTwo) {
		this.productNumTwo = productNumTwo;
	}

	public String getProductFactoryTwo() {
		return productFactoryTwo;
	}

	public void setProductFactoryTwo(String productFactoryTwo) {
		this.productFactoryTwo = productFactoryTwo;
	}

	public String getProductGMTTwo() {
		return productGMTTwo;
	}

	public void setProductGMTTwo(String productGMTTwo) {
		this.productGMTTwo = productGMTTwo;
	}

	public String getInputRangeTwo() {
		return inputRangeTwo;
	}

	public void setInputRangeTwo(String inputRangeTwo) {
		this.inputRangeTwo = inputRangeTwo;
	}

	public String getOutputRangeTwo() {
		return outputRangeTwo;
	}

	public void setOutputRangeTwo(String outputRangeTwo) {
		this.outputRangeTwo = outputRangeTwo;
	}

	public String getTestPointNumTwo() {
		return testPointNumTwo;
	}

	public void setTestPointNumTwo(String testPointNumTwo) {
		this.testPointNumTwo = testPointNumTwo;
	}

	public String getProductInputRange() {
		return productInputRange;
	}

	public void setProductInputRange(String productInputRange) {
		this.productInputRange = productInputRange;
	}

	public String getProductOutputRange() {
		return productOutputRange;
	}

	public void setProductOutputRange(String productOutputRange) {
		this.productOutputRange = productOutputRange;
	}

	public String getProductUseSpot() {
		return productUseSpot;
	}

	public void setProductUseSpot(String productUseSpot) {
		this.productUseSpot = productUseSpot;
	}

	public String getDeviceGenerateType() {
		return deviceGenerateType;
	}

	public void setDeviceGenerateType(String deviceGenerateType) {
		this.deviceGenerateType = deviceGenerateType;
	}

	public String getDeviceGenerateNum() {
		return deviceGenerateNum;
	}

	public void setDeviceGenerateNum(String deviceGenerateNum) {
		this.deviceGenerateNum = deviceGenerateNum;
	}

	public String getDeviceGenerateLevel() {
		return deviceGenerateLevel;
	}

	public void setDeviceGenerateLevel(String deviceGenerateLevel) {
		this.deviceGenerateLevel = deviceGenerateLevel;
	}

	public String getDeviceProofType() {
		return deviceProofType;
	}

	public void setDeviceProofType(String deviceProofType) {
		this.deviceProofType = deviceProofType;
	}

	public String getDeviceProofNum() {
		return deviceProofNum;
	}

	public void setDeviceProofNum(String deviceProofNum) {
		this.deviceProofNum = deviceProofNum;
	}

	public String getDeviceProofLevel() {
		return deviceProofLevel;
	}

	public void setDeviceProofLevel(String deviceProofLevel) {
		this.deviceProofLevel = deviceProofLevel;
	}

	public String getWorkProperty() {
		return workProperty;
	}

	public void setWorkProperty(String workProperty) {
		this.workProperty = workProperty;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getManagementCategory() {
		return managementCategory;
	}

	public void setManagementCategory(String managementCategory) {
		this.managementCategory = managementCategory;
	}

	public String getLiquidColumnCorrection() {
		return liquidColumnCorrection;
	}

	public void setLiquidColumnCorrection(String liquidColumnCorrection) {
		this.liquidColumnCorrection = liquidColumnCorrection;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getTimeSps() {
		return timeSps;
	}

	public void setTimeSps(String timeSps) {
		this.timeSps = timeSps;
	}

	public String getComNum() {
		return comNum;
	}

	public void setComNum(String comNum) {
		this.comNum = comNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBaudrate() {
		return baudrate;
	}

	public void setBaudrate(String baudrate) {
		this.baudrate = baudrate;
	}

	public String getDatabits() {
		return databits;
	}

	public void setDatabits(String databits) {
		this.databits = databits;
	}

	public String getStopbits() {
		return stopbits;
	}

	public void setStopbits(String stopbits) {
		this.stopbits = stopbits;
	}

	public String getParity() {
		return parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputUnit() {
		return inputUnit;
	}

	public void setInputUnit(String inputUnit) {
		this.inputUnit = inputUnit;
	}

	public String getInputLine() {
		return inputLine;
	}

	public void setInputLine(String inputLine) {
		this.inputLine = inputLine;
	}

	public String getInputHeigh() {
		return inputHeigh;
	}

	public void setInputHeigh(String inputHeigh) {
		this.inputHeigh = inputHeigh;
	}

	public String getInputLow() {
		return inputLow;
	}

	public void setInputLow(String inputLow) {
		this.inputLow = inputLow;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public String getOutputUnit() {
		return outputUnit;
	}

	public void setOutputUnit(String outputUnit) {
		this.outputUnit = outputUnit;
	}

	public String getOutputLine() {
		return outputLine;
	}

	public void setOutputLine(String outputLine) {
		this.outputLine = outputLine;
	}

	public String getOutputHeigh() {
		return outputHeigh;
	}

	public void setOutputHeigh(String outputHeigh) {
		this.outputHeigh = outputHeigh;
	}

	public String getOutputLow() {
		return outputLow;
	}

	public void setOutputLow(String outputLow) {
		this.outputLow = outputLow;
	}

	public String getBaseOffSet() {
		return baseOffSet;
	}

	public void setBaseOffSet(String baseOffSet) {
		this.baseOffSet = baseOffSet;
	}

	public String getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(String holdTime) {
		this.holdTime = holdTime;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getReturnError() {
		return returnError;
	}

	public void setReturnError(String returnError) {
		this.returnError = returnError;
	}

	@Override
	public String toString() {
		return "ConfigVo [productType=" + productType + ", productNum=" + productNum + ", productFactory="
				+ productFactory + ", productGMT=" + productGMT + ", inputRange=" + inputRange + ", outputRange="
				+ outputRange + ", testPointNum=" + testPointNum + ", productTypeTwo=" + productTypeTwo
				+ ", productNumTwo=" + productNumTwo + ", productFactoryTwo=" + productFactoryTwo + ", productGMTTwo="
				+ productGMTTwo + ", inputRangeTwo=" + inputRangeTwo + ", outputRangeTwo=" + outputRangeTwo
				+ ", testPointNumTwo=" + testPointNumTwo + ", productInputRange=" + productInputRange
				+ ", productOutputRange=" + productOutputRange + ", productUseSpot=" + productUseSpot
				+ ", deviceGenerateType=" + deviceGenerateType + ", deviceGenerateNum=" + deviceGenerateNum
				+ ", deviceGenerateLevel=" + deviceGenerateLevel + ", deviceProofType=" + deviceProofType
				+ ", deviceProofNum=" + deviceProofNum + ", deviceProofLevel=" + deviceProofLevel + ", workProperty="
				+ workProperty + ", temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", region="
				+ region + ", managementCategory=" + managementCategory + ", liquidColumnCorrection="
				+ liquidColumnCorrection + ", certificateNum=" + certificateNum + ", timeSps=" + timeSps + ", comNum="
				+ comNum + ", userId=" + userId + ", baudrate=" + baudrate + ", databits=" + databits + ", stopbits="
				+ stopbits + ", parity=" + parity + ", inputType=" + inputType + ", inputUnit=" + inputUnit
				+ ", inputLine=" + inputLine + ", inputHeigh=" + inputHeigh + ", inputLow=" + inputLow
				+ ", isChannelTwo=" + isChannelTwo + ", outputType=" + outputType + ", outputUnit=" + outputUnit
				+ ", outputLine=" + outputLine + ", outputHeigh=" + outputHeigh + ", outputLow=" + outputLow
				+ ", baseOffSet=" + baseOffSet + ", holdTime=" + holdTime + ", error=" + error + ", returnError="
				+ returnError + "]";
	}

}
