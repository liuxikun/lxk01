package com.example.lxk.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.lxk.entity.ActiveRequest;
import com.example.lxk.entity.BaseResult;
import com.example.lxk.entity.OptionRecord;
import com.example.lxk.entity.QueryCondition;
import com.example.lxk.enums.ResultEnum;
import com.example.lxk.model.Config;
import com.example.lxk.model.Validateresultentity;
import com.example.lxk.service.ConfigService;
import com.example.lxk.service.ValidateresultentityService;
import com.example.lxk.uils.BaseResultUtil;
import com.example.lxk.vo.ConfigVo;
import com.example.lxk.vo.ValidateresultentityVo;

@CrossOrigin
@Controller
public class ManageController {

	private final static Logger logger = LoggerFactory.getLogger(ManageController.class);
	@Autowired
	ConfigService configService;

	@Autowired
	ValidateresultentityService validateresultentityService;

	@RequestMapping(value = "/saveUserConfig", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult saveUserConfig(@RequestBody ConfigVo configVo) {
		BaseResult baseResult = null;
		Config config = new Config();
		try {
			if (Objects.isNull(configVo)) {
				baseResult = BaseResultUtil.error(ResultEnum.OPERATE_FAIL);
			}
			// 设置主键
			config.setConfigId(configVo.getConfigId());
			config.setUserId(configVo.getUserId());
			// 通道1设置
			config.setProductType(configVo.getProductType());
			config.setProductNum(configVo.getProductNum());
			config.setProductFactory(configVo.getProductFactory());
			config.setProductGMT(configVo.getProductGMT());
			config.setProductInputRange(configVo.getInputRange());
			config.setProductOutputRange(configVo.getOutputRange());
			// 通道2设置
			config.setProductTypeTwo(dealWithNull(configVo.getProductTypeTwo()));
			config.setProductNumTwo(dealWithNull(configVo.getProductNumTwo()));
			config.setProductFactoryTwo(dealWithNull(configVo.getProductFactoryTwo()));
			config.setProductGMTTwo(dealWithNull(configVo.getProductGMTTwo()));
			config.setProductInputRangeTwo(dealWithNull(configVo.getInputRangeTwo()));
			config.setProductOutputRangeTwo(dealWithNull(configVo.getOutputRangeTwo()));
			config.setDeviceProofTypeTwo(dealWithNull(configVo.getDeviceProofTypeTwo()));
			config.setDeviceGenerateLevel(configVo.getLevel());// --下位机1精度等级
			config.setDeviceGenerateNum(configVo.getDeviceGenerateNum());// --下位机1编号
			config.setDeviceGenerateType(configVo.getDeviceGenerateType());// --下位机1类型

			config.setDeviceProofLevel(configVo.getLevel());// --下位机2精度等级
			config.setDeviceProofType(configVo.getDeviceProofType());// --下位机2类型
			config.setDeviceGenerateNum(configVo.getDeviceGenerateNum());// --下位机2编号

			// 公共参数-输入
			config.setInputHeigh(configVo.getInputHeigh());
			config.setInputLow(configVo.getInputLow());
			config.setInputLine(configVo.getInputLine());
			config.setInputType(configVo.getInputType());

			// 公共参数-输出
			config.setOutputHeigh(configVo.getOutputHeigh());
			config.setOutputLow(configVo.getOutputLow());
			config.setOutputLine(configVo.getOutputLine());
			config.setOutputType(configVo.getOutputType());
			config.setManagementCategory(configVo.getManagementCategory());// --管理类别

			config.setLiquidColumnCorrection(configVo.getLiquidColumnCorrection());
			config.setRegion(configVo.getRegion());// --区域
			config.setRelativeHumidity(configVo.getRelativeHumidity());// --相对湿度
			config.setTemperature(configVo.getTemperature());// --室温
			config.setHoldTime(configVo.getHoldTime());// 稳压时间

			config.setWorkProperty(configVo.getWorkProperty());// --工作性质
			config.setDatabits(configVo.getDatabits());
			config.setStopbits(configVo.getStopbits());// 停止位
			config.setParity(configVo.getParity());// 校验位
			config.setIsChannelTwo(configVo.getIsChannelTwo());

			config.setCheckPoints(" - - ");// --测点编号
			config.setTestPointNum(configVo.getTestPointNum());// --测点编号
			config.setTestPointNumTwo(dealWithNull(configVo.getTestPointNumTwo()));// --测点编号2

			config.setCertificateNum(configVo.getCertificateNum());
			config.setBaudrate(configVo.getBaudrate());// 波特率
			config.setBaseOffSet(configVo.getBaseOffSet());
			config.setError(configVo.getError());
			config.setProductLevel(configVo.getLevel());// 精度
			config.setReturnError(configVo.getReturnError());// 回差允许值
			config.setOutputUnit(configVo.getOutputUnit());
			config.setInputUnit(configVo.getInputUnit());
			config.setIp(dealWithNull(configVo.getIp()));
			config.setCity(dealWithNull(configVo.getCity()));
			config.setCom(dealWithNull(configVo.getCom()));
			LocalDateTime gmt = LocalDateTime.now();
			config.setGmt(gmt);
			configService.saveConfig(config);
			baseResult = BaseResultUtil.success();
			logger.info("---save configId--" + baseResult.getCode().toString());

		} catch (Exception e) {
			baseResult = BaseResultUtil.error(ResultEnum.OPERATE_FAIL);
			logger.info("---error-is---" + e.getMessage());
		}
		return baseResult;
	}

	@RequestMapping("/queryUserConfigByGMT")
	@ResponseBody
	public BaseResult queryUserConfigByGMT(String userId, String saveTime) {
		logger.info("---configId.toString()---" + userId.toString());
		BaseResult baseResult = new BaseResult();
		Config config = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		try {
			Date tmpDate = sdf.parse(saveTime);
			calendar.setTime(tmpDate);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
			Date saveTimeEnd = calendar.getTime();
			config = configService.queryUserConfigByGMT(userId, tmpDate, saveTimeEnd);
			if (config != null) {
				baseResult.setData(JSON.toJSON(config));
				logger.info("---JSON.toJSON(config)---" + JSON.toJSON(config));
			} else {
				baseResult = BaseResultUtil.success(ResultEnum.FIND_FAILURE_ISEMPTY);
			}
		} catch (Exception e) {
			baseResult = BaseResultUtil.success(ResultEnum.OPERATE_FAIL);
		}
		return baseResult;
	}

	@RequestMapping(value = "/queryOption", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult queryOption(String userId, String optTime, String pageCount) {
		if (null == optTime || "".equals(optTime) || " ".equals(optTime)) {
			return new BaseResult();
		}
		BaseResult baseResult = new BaseResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<OptionRecord> optionRecord = null;
		QueryCondition queryCondition = new QueryCondition();
		JSONArray jsonArray = new JSONArray();

		
		try {
			Date tmpDate = sdf.parse(optTime);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(tmpDate);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);

			Date gmtCreateEnd = calendar.getTime();

			if (null != userId) {
				queryCondition.setUserId(userId);
			}
			queryCondition.setPageCount(Integer.valueOf(pageCount));
			optionRecord = configService.queryOption(queryCondition);
			for (OptionRecord opt : optionRecord) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("configId", opt.getConfigId());
				jsonObject.put("userId", opt.getUserId());
				jsonObject.put("isChannelTwo", opt.getIsChannelTwo());
				jsonObject.put("port", opt.getPort());
				jsonObject.put("ip", opt.getIp());
				jsonObject.put("city", opt.getCity());
				jsonObject.put("com", opt.getCom());

				if ((opt.getGmtCreate().toString().indexOf('T') != -1)) {
					jsonObject.put("gmtCreate", opt.getGmtCreate().toString().replace("T", " "));
					logger.info("返回日期格式    ====  " + opt.getGmtCreate().toString().replace("T", " "));
				}
				jsonArray.add(jsonObject);
			}
			baseResult.setData(jsonArray);
		} catch (Exception e) {
			baseResult = BaseResultUtil.success(ResultEnum.OPERATE_FAIL);
		}
		return baseResult;
	}

	/*
	 * 查询数据，数据库中的数据是已经处理好的，有对应的误差值和是否合格
	 */
	@RequestMapping("/queryEntityData")
	@ResponseBody
	public BaseResult queryUserConfigData(String userId, String comNum, String optTime) {
		BaseResult baseResult = new BaseResult();
		StringJoiner sb = new StringJoiner("");
		StringJoiner configId = sb.add(userId).add(comNum);
		List<Validateresultentity> list = null;
		try {

			baseResult.setData(list);
		} catch (Exception e) {
			baseResult = BaseResultUtil.error(ResultEnum.OPERATE_FAIL);
		}
		return baseResult;
	}

	@RequestMapping(value = "/returnDateList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult returnDateList(HttpServletRequest request, String userId, String comNum) {
		BaseResult baseResult = null;
		StringJoiner sb = new StringJoiner("");
		StringJoiner configId = sb.add(userId).add(comNum);
		List<String> list = null;
		logger.info("---configId.toString()---" + configId.toString());
		try {
			list = validateresultentityService.returnDataListByConfigId(configId.toString());
			baseResult = BaseResultUtil.success();
			baseResult.setData(list);
			logger.info("---baseResult.getData---" + baseResult.getData().toString());
		} catch (Exception e) {
			baseResult = BaseResultUtil.error(ResultEnum.ADD_FAILURE);
		}
		return baseResult;

	}

	/*
	 * 保存nodejs传过来的实时数据
	 */
	@RequestMapping(value = "/saveEntityData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public BaseResult saveUserConfigData(@RequestBody ActiveRequest request) {
		logger.info("---saveUserConfigData---" + request.getEntityList());
		logger.info("---size is---" + request.getEntityList().size());
		BaseResult baseResult = null;
		String configId = request.getConfigId();
		
		List<ValidateresultentityVo> entityList = request.getEntityList();
		int maxPointNum = 1;
		for (ValidateresultentityVo validateresultentityVo : entityList) {
			if(Integer.valueOf(validateresultentityVo.getPointNum()).intValue() > maxPointNum) {
				maxPointNum = Integer.valueOf(validateresultentityVo.getPointNum()).intValue();
			}
		}
		logger.info("---maxPointNum---" + maxPointNum);
		int theNumberOfVersion = (entityList.size()/maxPointNum);
		logger.info("---theNumberOfVersion---" + theNumberOfVersion);
		
		LocalDateTime gmtCreate = LocalDateTime.now();
		int version = 1;
		
		List<Validateresultentity> dataList = new LinkedList<Validateresultentity>();
		for (int i = 0; i < entityList.size(); i++) {
			Validateresultentity validateresultentity = new Validateresultentity();
        	validateresultentity.setConfigId(configId);
        	validateresultentity.setRealTimePre(entityList.get(i).getRealTimePre());
        	validateresultentity.setOutputValue(entityList.get(i).getOutputValue());
        	validateresultentity.setPointNum(entityList.get(i).getPointNum());
        	validateresultentity.setGmtCreate(gmtCreate);
        	validateresultentity.setInputValue(entityList.get(i).getInputValue());
        	
        	validateresultentity.setError1(entityList.get(i).getError1());
        	validateresultentity.setError2(entityList.get(i).getError2());
        	validateresultentity.setChannelOne(entityList.get(i).getChannelOne());
        	validateresultentity.setChannelTwo(entityList.get(i).getChannelTwo());
        	validateresultentity.setValidateResultOne(entityList.get(i).getValidate_result_one());
        	validateresultentity.setValidateResultTwo(entityList.get(i).getValidate_result_two());
        	validateresultentity.setVersion(String.valueOf(version));
        	if(i>0 && (i+1)%maxPointNum == 0) {
        		version ++;
        		logger.info("---version---" + version);
        	}
        	dataList.add(validateresultentity);
		}
		
		logger.info("---configId---" + configId);
		try {
			validateresultentityService.insertValidateresultentity(dataList);
			baseResult = BaseResultUtil.success();
		} catch (Exception e) {
			baseResult = BaseResultUtil.error(ResultEnum.ADD_FAILURE);
		}
		return baseResult;

	}

	public String dealWithNull(String string) {
		if (null == string) {
			return new String(" - - ");
		}
		return string;
	}

}
