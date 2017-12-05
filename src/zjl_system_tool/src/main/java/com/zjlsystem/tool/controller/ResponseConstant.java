/**
 * @Title: ResponseConstant.java
 * @Package com.zjlsystem.tool.controller
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月26日 下午9:07:54
 * @version V1.0
 */

package com.zjlsystem.tool.controller;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @ClassName: ResponseConstant
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月26日 下午9:07:54
 *
 */

public class ResponseConstant {
	/* 回复成功 */
	public static final String RESPONSESUCCESS = "1";
	/* 回复失败 */
	public static final String RESPONSEFAILURE = "-1";

	public static final String USERINSERTSUCCESS = "添加用户成功";
	public static final String USERINSERTFAILURE = "添加用户失败";	
	public static final String USERDELETESUCCESS = "删除用户成功";
	public static final String USERDELETEFAILURE = "删除用户失败";	
	public static final String USERUPDATESUCCESS = "更新用户成功";
	public static final String USERUPDATEFAILURE = "更新用户失败";
	
	public static final String USERLOGOUTSUCCESS = "用户登出成功";
	public static final String USERLOGOUTFAILURE = "用户登出失败";
	
	public static final String USERLOGINSUCCESS = "用户登录成功";
	public static final String USERLOGINFAILURE = "用户登录失败";
	public static final String USERFORBID = "用户被禁用";
	public static final String USERACCOUNTORPWDERROR = "用户名或密码错误";
	
	
	
	public static final String MENUINSERTSUCCESS = "菜单添加成功";
	public static final String MENUINSERTFAILURE = "菜单添加失败";
	
	
	public static final String ROLEINSERTSUCCESS = "角色添加成功";
	public static final String ROLEINSERTFAILURE = "角色添加失败";
	
	
	public static final String BUTTONINSERTSUCCESS = "按钮添加成功";
	public static final String BUTTONINSERTFAILURE = "按钮添加失败";
	
	/* 成功 */
	public static String ResponseSuccess(String msg, List<Object> list) {
		JsonObject jORoot = new JsonObject();
		jORoot.addProperty("Code", RESPONSESUCCESS);
		jORoot.addProperty("Msg", msg);

		String data = new Gson().toJson(list);
		jORoot.addProperty("Data", data);
		return jORoot.toString();

	}

	public static String ResponseSuccess(String msg, Object obj) {
		JsonObject jORoot = new JsonObject();
		jORoot.addProperty("Code", RESPONSESUCCESS);
		jORoot.addProperty("Msg", msg);

		String data = new Gson().toJson(obj);
		jORoot.addProperty("Data", data);
		return jORoot.toString();

	}

	public static String ResponseSuccess(String msg) {
		JsonObject jORoot = new JsonObject();
		jORoot.addProperty("Code", RESPONSESUCCESS);
		jORoot.addProperty("Msg", msg);

		jORoot.addProperty("Data", "");
		return jORoot.toString();

	}

	/* 失败 */
	public static String ResponseFailure(String msg) {
		JsonObject jORoot = new JsonObject();
		jORoot.addProperty("Code", RESPONSEFAILURE);
		jORoot.addProperty("Msg", msg);
		jORoot.addProperty("Data", "");
		return jORoot.toString();

	}
}
