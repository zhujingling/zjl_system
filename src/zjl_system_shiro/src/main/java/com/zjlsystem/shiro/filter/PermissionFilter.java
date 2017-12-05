/**
 * @Title: PermissionFilter.java
 * @Package com.zjlsystem.shiro.filter
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午11:04:32
 * @version V1.0
 */

package com.zjlsystem.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.zjlsystem.tool.common.LoggerUtils;

/**
 * @ClassName: PermissionFilter
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午11:04:32
 *
 */

public class PermissionFilter extends AccessControlFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {

		// 先判断带参数的权限判断
		Subject subject = getSubject(request, response);
		if (null != mappedValue) {
			String[] arra = (String[]) mappedValue;
			for (String permission : arra) {
				if (subject.isPermitted(permission)) {
					return Boolean.TRUE;
				}
			}
		}
		// 取到请求的uri ，进行权限判断
		/* String uri = ((HttpServletRequest) request).getRequestURI(); */
		/* String uri = ((HttpServletRequest) request).getRequestURI(); */
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String uri = httpServletRequest.getRequestURI().replace(httpServletRequest.getContextPath(), "");
		if (subject.isPermitted(uri)) {
			return Boolean.TRUE;
		}
		if (ShiroFilterUtils.isAjax(request)) {
			Map<String, String> resultMap = new HashMap<String, String>();
			LoggerUtils.debug(getClass(), "当前用户没有登录，并且是Ajax请求！");
			resultMap.put("login_status", "300");
			resultMap.put("message", "当前用户没有登录！");// 当前用户没有登录！
			ShiroFilterUtils.out(response, resultMap);
		}
		return Boolean.FALSE;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		Subject subject = getSubject(request, response);
		if (null == subject.getPrincipal()) {// 表示没有登录，重定向到登录页面
			saveRequest(request);
			WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
		} else {
			if (StringUtils.hasText(ShiroFilterUtils.UNAUTHORIZED)) {// 如果有未授权页面跳转过去
				WebUtils.issueRedirect(request, response, ShiroFilterUtils.UNAUTHORIZED);
			} else {// 否则返回401未授权状态码
				WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		return Boolean.FALSE;
	}

}
