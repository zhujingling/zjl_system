/**
 * @Title: ShiroFilterUtils.java
 * @Package com.zjlsystem.shiro.filter
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午10:52:41
 * @version V1.0
 */

package com.zjlsystem.shiro.filter;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.zjlsystem.tool.common.LoggerUtils;

/**
 * @ClassName: ShiroFilterUtils
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午10:52:41
 *
 */

public class ShiroFilterUtils {
	final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;
	// 登录页面
	static final String LOGIN_URL = "/system/login.shtml";
	// 踢出登录提示
	final static String KICKED_OUT = "/system/kickedOut.shtml";
	// 没有权限提醒
	final static String UNAUTHORIZED = "/system/unauthorized.shtml";

	/*
	 * 是否是Ajax请求
	 * 
	 * @param request
	 * 
	 * @return
	 */
	public static boolean isAjax(ServletRequest request) {
		return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
	}

	/*
	 * response 输出JSON
	 * 
	 * @param hresponse
	 * 
	 * @param resultMap
	 * 
	 * @throws IOException
	 */
	public static void out(ServletResponse response, Map<String, String> resultMap) {

		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			out.println(new Gson().toJson(resultMap));
		} catch (Exception e) {
			LoggerUtils.fmtError(CLAZZ, e, "输出JSON报错。");
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}
}
