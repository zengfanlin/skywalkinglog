package com.example.provider;

import java.util.List;


import com.alibaba.fastjson.annotation.JSONField;


/**
 * 返回结果类
 *
 * @author fanlin.zeng
 * @date 2017/11/9 23:45
 */

public class ResponsData {

	public ResponsData(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponsData(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ResponsData(int code, String message, Object data, long count) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.count = (int) count;
	}

	/**
	 * 是否成功
	 */
	@JSONField(ordinal = 0)
	public Boolean success;
	/**
	 * 状态码
	 */
	@JSONField(ordinal = 1)
	public int code;

	/**
	 * 描述
	 */
	@JSONField(ordinal = 2)
	public String message;

	/**
	 * 数据结果集
	 */
	@JSONField(ordinal = 4)
	public Object data;

	/**
	 * 分页结果记录数
	 */
	@JSONField(ordinal = 3)
	public int count;

	/**
	 * @param
	 * @return ResponsData
	 */
	public static ResponsData Success(String message) {
		return new ResponsData(ResultCodeEnum.SUCCESS.value(), message);
	}

	public static ResponsData Success() {
		return new ResponsData(ResultCodeEnum.SUCCESS.value(), "");
	}

	public static ResponsData Error(String message) {
		return new ResponsData(ResultCodeEnum.INTERNAL_SERVER_ERROR.value(), message);
	}

	public static ResponsData Error(Integer code, String message) {
		return new ResponsData(code, message);
	}

	public static ResponsData Data(Object data) {
		return new ResponsData(ResultCodeEnum.SUCCESS.value(), "", data);
	}

	public Boolean getSuccess() {
		return code == 200;
	}
}
