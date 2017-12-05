/**
 * @Title: LoginFilter.java
 * @Package com.zjlsystem.shiro.filter
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午10:49:28
 * @version V1.0
 */

package com.zjlsystem.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;

import com.zjlsystem.entity.permissions.SystemUser;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.common.LoggerUtils;

/**
  * @ClassName: LoginFilter
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月23日 下午10:49:28
  *
  */

public class LoginFilter extends AccessControlFilter {
	final static Class<LoginFilter> CLASS = LoginFilter.class;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

		SystemUser token = TokenManager.getToken();

		if (null != token || isLoginRequest(request, response)) {// &&
																	// isEnabled()
			return Boolean.TRUE;
		}
		if (ShiroFilterUtils.isAjax(request)) {// ajax请求
			Map<String, String> resultMap = new HashMap<String, String>();
			LoggerUtils.debug(getClass(), "当前用户没有登录，并且是Ajax请求！");
			resultMap.put("login_status", "300");
			resultMap.put("message", "当前用户没有登录");// 当前用户没有登录！
			ShiroFilterUtils.out(response, resultMap);
		}
		return Boolean.FALSE;

	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 保存Request和Response 到登录后的链接
		saveRequestAndRedirectToLogin(request, response);
		return Boolean.FALSE;
	}


}
