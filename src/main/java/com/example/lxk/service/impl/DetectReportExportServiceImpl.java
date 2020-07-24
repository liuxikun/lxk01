package com.example.lxk.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.lxk.entity.DetectionInfoDO;
import com.example.lxk.entity.PageConstant;
import com.example.lxk.enums.ResultEnum;
import com.example.lxk.exception.ServiceException;
import com.example.lxk.model.Config;
import com.example.lxk.model.Validateresultentity;
import com.example.lxk.service.ConfigService;
import com.example.lxk.service.DetectReportExportService;
import com.example.lxk.service.ValidateresultentityService;
import com.example.lxk.uils.DateUtil;
import com.example.lxk.uils.DetectReportUtil;

@Service
public class DetectReportExportServiceImpl implements DetectReportExportService {

	private final static Logger log = LoggerFactory.getLogger(DetectReportExportServiceImpl.class);

	@Autowired
	private DetectReportUtil detectReportUtil;

	@Autowired
	private ConfigService configService;

	@Autowired
	private ValidateresultentityService validateresultentityService;

	@Override
	public void reportDownload(HttpServletResponse response, String configId) {
		// TODO Auto-generated method stub
		// 生成导出的文件名称
		String date = DateUtil.format(new Date(), DateUtil.DATE_PATTERN);
		String fileName = PageConstant.DETECT_REPORT_FILE_NAME.replace("{A}", date);
		log.info("生成的文件名称为：{}" + fileName);

		Config config = configService.queryConfig(configId);
		if (null == config) {
			log.info("no config data -- config is null");
			throw new ServiceException(ResultEnum.REPORT_DOWNLOAD_NULL);
		}

		// 最大序列数
		int count = validateresultentityService.findLengthForOneOperation(configId);
		log.info("------最大序列数------" + count);

		int total = validateresultentityService.findTotalDataNumber(configId);
		log.info("------数据总长度------" + total);

		int length = (total / count);
		log.info("------for循环长度------" + length);

		int useNumber = 1;
		List<Validateresultentity> validateresultentitiesOne = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(useNumber));
		log.info("validateresultentitiesOne 长度是 --" + validateresultentitiesOne.size());
		
		log.info("------JSON.toJSONString------" + JSON.toJSONString(validateresultentitiesOne));

		List<Validateresultentity> validateresultentitiesLast = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(length - 1));
		log.info("validateresultentitiesLast 长度是 --" + validateresultentitiesOne.size());

		List<Validateresultentity> validateresultentitiesFinal = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(length));
		log.info("validateresultentitiesFinal 长度是 --" + validateresultentitiesOne.size());

		if (validateresultentitiesOne.size() < 0 || validateresultentitiesLast.size() < 0
				|| validateresultentitiesFinal.size() < 0) {
			log.info("---------校验次数小于3次----------");
			throw new ServiceException(ResultEnum.REPORT_DOWNLOAD_NULL);
		}
		Map<String, Object> map = generateMapData(config, validateresultentitiesOne, validateresultentitiesLast,
				validateresultentitiesFinal);
		detectReportUtil.reportDownload(map, fileName, response);
	}

	/**
	 * 测试数据
	 * 
	 * @return
	 */
	public static Map<String, Object> generateMapData(Config config,
			List<Validateresultentity> validateresultentitiesOne, List<Validateresultentity> validateresultentitiesLast,
			List<Validateresultentity> validateresultentitiesFinal) {

		BigDecimal tmp = new BigDecimal("0.01");
		log.info("--------generateMapData--------");
		Map<String, Object> map = new HashMap<>();
		List<DetectionInfoDO> detectionInfoDOList = new ArrayList<>();
		// 最大误差值
		BigDecimal errorTmp = null;
		// 误差数组
		List<BigDecimal> errorList = new ArrayList<>();
		// 最大回差值
		BigDecimal returnErrorTmp = null;
		List<BigDecimal> list = new ArrayList<>();

		String isRight = "合格";
		for (int i = 0; i < validateresultentitiesOne.size(); i++) {
			DetectionInfoDO detectionInfoDO = new DetectionInfoDO();
			detectionInfoDO.setPointNo(validateresultentitiesOne.get(i).getPointNum());
			detectionInfoDO.setStandardInput(validateresultentitiesOne.get(i).getRealTimePre());
			detectionInfoDO.setStandardOutput(validateresultentitiesOne.get(i).getOutputValue());

			// 第一次校验的结果
			if (validateresultentitiesOne.get(i).getValidateResultOne().equals("不合格")) {
				isRight = "不合格";
			}
			// 倒数第二次校验结果
			if (validateresultentitiesLast.get(i).getValidateResultOne().equals("不合格")) {
				isRight = "不合格";
			}
			// 最后一次的校验结果
			if (validateresultentitiesFinal.get(i).getValidateResultOne().equals("不合格")) {
				isRight = "不合格";
			}

			detectionInfoDO.setFirstRise(
					new BigDecimal(validateresultentitiesOne.get(i).getChannelOne()).subtract(tmp).toString());
			detectionInfoDO
					.setFirstFall(new BigDecimal(validateresultentitiesOne.get(i).getChannelOne()).add(tmp).toString());

			// 倒数第二次
			detectionInfoDO.setSecondRise(
					new BigDecimal(validateresultentitiesLast.get(i).getChannelOne()).subtract(tmp).toString());
			detectionInfoDO.setSecondFall(
					new BigDecimal(validateresultentitiesLast.get(i).getChannelOne()).add(tmp).toString());

			// 只有升序的过程是正确的
			detectionInfoDO.setThirdRise(
					new BigDecimal(validateresultentitiesFinal.get(i).getChannelOne()).subtract(tmp).toString());
			detectionInfoDO.setThirdFall(
					new BigDecimal(validateresultentitiesFinal.get(i).getChannelOne()).add(tmp).toString());

			errorList.add(new BigDecimal(validateresultentitiesFinal.get(i).getError1()));
			detectionInfoDO.setBasicErrorRise(validateresultentitiesFinal.get(i).getError1());
			errorTmp = new BigDecimal(validateresultentitiesFinal.get(i).getChannelOne())
					.subtract(new BigDecimal(validateresultentitiesFinal.get(i).getOutputValue()));
			detectionInfoDO.setBasicErrorFall(errorTmp.toString());
			errorList.add(errorTmp);

			returnErrorTmp = new BigDecimal(detectionInfoDO.getBasicErrorFall())
					.subtract(new BigDecimal(detectionInfoDO.getBasicErrorRise()));
			list.add(returnErrorTmp);
			detectionInfoDO.setReturnErrors(returnErrorTmp.toString());
			detectionInfoDOList.add(detectionInfoDO);
		}

		map.put("DetectionInfoDOList", detectionInfoDOList);// channel1数据

		/**
		 * 表头数据
		 */
		// 对应模板属性-型号规格
		map.put("tableType", dealNullValue(config.getProductType())); // 被检设备类型
		// 对应模板属性-准确度等级
		map.put("accuracy", dealNullValue(config.getProductLevel()));

		// 对应模板属性-制造商
		map.put("manufacture", dealNullValue(config.getProductFactory())); // 被检设备生产厂家
		// 对应模板属性-出厂编号
		map.put("serialNo", dealNullValue(config.getProductNum()));

		// 对应模板属性-测量范围
		map.put("measuringRange", dealNullValue(config.getProductInputRange())); // 测 量 范 围

		// 对应模板属性-检测时温度
		map.put("roomTemperature", dealNullValue(config.getTemperature())); // 温度
		// 对应模板属性-相对湿度

		// 标准气-名称1 pressureStandardType
		map.put("PST", dealNullValue(config.getDeviceGenerateType()));// 下位机-压力生成设备-设备型号
		// 标准气-准确度等级 accuracy1
		map.put("a1", dealNullValue(config.getDeviceGenerateLevel()));// 下位机-压力生成设备-设备精度
		// 标准气-测量范围 ProductInputRange
		map.put("productIR", dealNullValue(config.getProductInputRange()));// 下位机-压力生成设备-测量范围
		// 标准气-编号 deviceGenerateNum
		map.put("sNo1", dealNullValue(config.getDeviceGenerateNum())); // 下位机-压力生成设备-设备编号

		// 标准气-名称2 proofreadStandard
		map.put("pSd", dealNullValue(config.getDeviceProofType()));// 下位机-压力校验设备-设备型号
		// 标准气-准确度等级 accuracy2
		map.put("a2", dealNullValue(config.getDeviceProofLevel()));// 下位机-压力校验设备-设备精度
		// 标准气-测量范围 productInputRangeTwo
		map.put("productIR2", dealNullValue(config.getProductInputRangeTwo()));// 下位机-压力校验设备-测量范围
		// sNo2
		map.put("sNo2", dealNullValue(config.getDeviceProofNum()));// 下位机-压力校验设备-设备编号

		// 1：示值误差-最大允许值
		map.put("error", dealNullValue(config.getError()));
		// 2：示值误差-实际值
		Object obj = Collections.max(errorList);
		map.put("maxerror", obj.toString());

		// 1：回差-最大允许值
		map.put("reterror", dealNullValue(config.getError()));
		// 2：回差-最大值
		Object obj2 = Collections.max(list);
		map.put("mreterror", obj2.toString());

		map.put("IU", dealNullValue(config.getInputLine()));// 输入单位
		// map.put("OU", dealNullValue(config.getOutputLine()));//输出单位
		map.put("OU", "mA");// 输出单位
		map.put("YY", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		// System.out.println("--YEAR--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		map.put("DD", String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		// System.out.println("--DAY_OF_MONTH--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		map.put("MM", String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
		// System.out.println("--MONTH--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
		map.put("res", isRight);

		return map;
	}

	public static String dealNullValue(String string) {
		if (null == string) {
			return new String(" - - ");
		}
		return string;
	}

	@Override
	public void reportTwoDownload(HttpServletResponse response, String configId) {
		// TODO Auto-generated method stub
		String date = DateUtil.format(new Date(), DateUtil.DATE_PATTERN);
		String fileName = PageConstant.DETECT_REPORT_FILE_NAME.replace("{A}", date);
		log.info("生成的文件名称为：{}" + fileName);

		// 最大序列数
		int count = validateresultentityService.findLengthForOneOperation(configId);
		log.info("------最大序列数------" + count);

		int total = validateresultentityService.findTotalDataNumber(configId);
		log.info("------数据总长度------" + total);

		int length = (total / count);
		log.info("------for循环长度------" + length);

		int useNumber = 1;
		List<Validateresultentity> validateresultentitiesOne = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(useNumber));
		log.info("validateresultentitiesOne 长度是 --" + validateresultentitiesOne.size());

		List<Validateresultentity> validateresultentitiesLast = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(length - 1));
		log.info("validateresultentitiesLast 长度是 --" + validateresultentitiesOne.size());

		List<Validateresultentity> validateresultentitiesFinal = validateresultentityService
				.queryValidateresultentityByCondition(configId, String.valueOf(length));
		log.info("validateresultentitiesFinal 长度是 --" + validateresultentitiesOne.size());

		Config config = configService.queryConfig(configId);
		if (null == config) {
			log.info("---config is null----");
			throw new ServiceException(ResultEnum.REPORT_DOWNLOAD_NULL);
		}

		if (validateresultentitiesOne.size() < 0) {
			log.info("---validateresultentities.size() < 0----");
			throw new ServiceException(ResultEnum.REPORT_DOWNLOAD_NULL);
		}

		Map<String, Object> map = generateMapDataChannelTwo(config, validateresultentitiesOne, validateresultentitiesLast,
				validateresultentitiesFinal);
		detectReportUtil.reportDownload(map, fileName, response);
	}

	public static Map<String, Object> generateMapDataChannelTwo(Config config,
			List<Validateresultentity> validateresultentitiesOne, List<Validateresultentity> validateresultentitiesLast,
			List<Validateresultentity> validateresultentitiesFinal) {

		log.info("--------generateMapDataChannelTwo--------");
		Map<String, Object> map = new HashMap<>();
		List<DetectionInfoDO> detectionInfoDOList = new ArrayList<>();
		BigDecimal tmp1 = new BigDecimal("0.01");
		// 最大误差值
		BigDecimal errorTmp = null;
		// 误差数组
		List<BigDecimal> errorList = new ArrayList<>();

		// 最大回差值
		BigDecimal returnErrorTmp = null;
		List<BigDecimal> list = new ArrayList<>();

		String isRight = "合格";
		log.info("validateresultentitiesOne 长度是 --" + validateresultentitiesOne.size());
		for (int i = 0; i < validateresultentitiesOne.size(); i++) {
			log.info("i 长度是 --" + i);
			DetectionInfoDO detectionInfoDO = new DetectionInfoDO();
			detectionInfoDO.setPointNo(validateresultentitiesOne.get(i).getPointNum());
			detectionInfoDO.setStandardInput(validateresultentitiesOne.get(i).getRealTimePre());
			detectionInfoDO.setStandardOutput(validateresultentitiesOne.get(i).getOutputValue());
			if (validateresultentitiesOne.get(i).getValidateResultTwo().equals("不合格")) {
				isRight = "不合格";
			}

			// 预期值，统一减去0.005
			detectionInfoDO.setFirstRise(new BigDecimal(validateresultentitiesOne.get(i).getChannelTwo()).toString());
			detectionInfoDO.setFirstFall(
					new BigDecimal(validateresultentitiesOne.get(i).getChannelTwo()).add(tmp1).toString());

			// 预期值，统一加上0.005
			detectionInfoDO.setSecondRise(new BigDecimal(validateresultentitiesLast.get(i).getChannelTwo()).toString());
			detectionInfoDO.setSecondFall(
					new BigDecimal(validateresultentitiesLast.get(i).getChannelTwo()).add(tmp1).toString());

			// 只有升序的过程是正确的
			detectionInfoDO.setThirdRise(validateresultentitiesFinal.get(i).getChannelTwo());
			detectionInfoDO.setThirdFall(
					new BigDecimal(validateresultentitiesFinal.get(i).getChannelTwo()).add(tmp1).toString());

			errorList.add(new BigDecimal(validateresultentitiesOne.get(i).getError1()));
			detectionInfoDO.setBasicErrorRise(validateresultentitiesOne.get(i).getError1());
			errorTmp = new BigDecimal(validateresultentitiesOne.get(i).getChannelTwo())
					.subtract(new BigDecimal(validateresultentitiesOne.get(i).getOutputValue()));
			detectionInfoDO.setBasicErrorFall(errorTmp.toString());
			errorList.add(errorTmp);

			returnErrorTmp = new BigDecimal(detectionInfoDO.getBasicErrorFall())
					.subtract(new BigDecimal(detectionInfoDO.getBasicErrorRise()));
			list.add(returnErrorTmp);
			detectionInfoDO.setReturnErrors(returnErrorTmp.toString());
			detectionInfoDOList.add(detectionInfoDO);
		}

		map.put("DetectionInfoDOList", detectionInfoDOList);// channel1数据

		/**
		 * 表头数据
		 */
		// 对应模板属性-型号规格
		map.put("tableType", dealNullValue(config.getProductType())); // 被检设备类型
		// 对应模板属性-准确度等级
		map.put("accuracy", dealNullValue(config.getProductLevel()));

		// 对应模板属性-制造商
		map.put("manufacture", dealNullValue(config.getProductFactory())); // 被检设备生产厂家
		// 对应模板属性-出厂编号
		map.put("serialNo", dealNullValue(config.getProductNum()));

		// 对应模板属性-测量范围
		map.put("measuringRange", dealNullValue(config.getProductInputRange())); // 测 量 范 围

		// 对应模板属性-检测时温度
		map.put("roomTemperature", dealNullValue(config.getTemperature())); // 温度
		// 对应模板属性-相对湿度

		// 标准气-名称1 pressureStandardType
		map.put("PST", dealNullValue(config.getDeviceGenerateType()));// 下位机-压力生成设备-设备型号
		// 标准气-准确度等级 accuracy1
		map.put("a1", dealNullValue(config.getDeviceGenerateLevel()));// 下位机-压力生成设备-设备精度
		// 标准气-测量范围 ProductInputRange
		map.put("productIR", dealNullValue(config.getProductInputRange()));// 下位机-压力生成设备-测量范围
		// 标准气-编号 deviceGenerateNum
		map.put("sNo1", dealNullValue(config.getDeviceGenerateNum())); // 下位机-压力生成设备-设备编号

		// 标准气-名称2 proofreadStandard
		map.put("pSd", dealNullValue(config.getDeviceProofType()));// 下位机-压力校验设备-设备型号
		// 标准气-准确度等级 accuracy2
		map.put("a2", dealNullValue(config.getDeviceProofLevel()));// 下位机-压力校验设备-设备精度
		// 标准气-测量范围 productInputRangeTwo
		map.put("productIR2", dealNullValue(config.getProductInputRangeTwo()));// 下位机-压力校验设备-测量范围
		// sNo2
		map.put("sNo2", dealNullValue(config.getDeviceProofNum()));// 下位机-压力校验设备-设备编号

		// 1：示值误差-最大允许值
		map.put("error", dealNullValue(config.getError()));
		// 2：示值误差-实际值
		Object obj = Collections.max(errorList);
		map.put("maxerror", obj.toString());

		// 1：回差-最大允许值
		map.put("reterror", dealNullValue(config.getError()));
		// 2：回差-最大值
		Object obj2 = Collections.max(list);
		map.put("mreterror", obj2.toString());

		map.put("IU", dealNullValue(config.getInputLine()));// 输入单位
		// map.put("OU", dealNullValue(config.getOutputLine()));//输出单位
		map.put("OU", "mA");// 输出单位
		map.put("YY", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

		// System.out.println("--YEAR--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		map.put("DD", String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		// System.out.println("--DAY_OF_MONTH--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
		map.put("MM", String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
		// System.out.println("--MONTH--" +
		// String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1));
		map.put("res", isRight);
		return map;
	}
}
