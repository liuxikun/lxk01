package com.example.lxk.uils;

import com.example.lxk.entity.BaseResult;
import com.example.lxk.enums.ResultEnum;

/**
 * 返回数据工具类
 * 
 * @author zpz
 * @date 2019/01/02
 */
public class BaseResultUtil {

	public static BaseResult success(ResultEnum resultEnum, Object data, Object token) {

		return new BaseResult(resultEnum.getCode(), resultEnum.getMessage(), data, token);
	}

	public static BaseResult success(Object object) {

		return new BaseResult(0, "操作成功", object);
	}

	public static BaseResult success() {

		return new BaseResult(200, "操作成功");
	}

	public static BaseResult saveSuccess() {

		return new BaseResult(1006, "保存空配置失败");
	}

	public static BaseResult accept() {

		return new BaseResult(1007, "用户名应包含数字和字母");
	}

	public static BaseResult registSuccess() {

		return new BaseResult(200, "操作成功");
	}

	public static BaseResult success(ResultEnum resultEnum, Object object) {

		return new BaseResult(resultEnum.getCode(), resultEnum.getMessage(), object);
	}

	public static BaseResult error(ResultEnum resultEnum) {

		return new BaseResult(resultEnum.getCode(), resultEnum.getMessage());
	}

	public static BaseResult error(int errorCode, String errorMessage) {

		return new BaseResult(errorCode, errorMessage);
	}
}
