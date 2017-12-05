/**
 * @Title: RoleFilter.java
 * @Package com.zjlsystem.shiro.filter
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午11:01:02
 * @version V1.0
 */

package com.zjlsystem.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;


/**
  * @ClassName: RoleFilter
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月23日 下午11:01:02
  *
  */

public class RoleFilter extends AccessControlFilter {

	static final String LOGIN_URL = "http://www.bh.com/system/login.shtml";
	static final String UNAUTHORIZED_URL = "http://www.bh.com/unauthorized.html";

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		String[] arra = (String[]) mappedValue;

		Subject subject = getSubject(request, response);
		for (String role : arra) {
			if (subject.hasRole("role:" + role)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		Subject subject = getSubject(request, response);
		if (subject.getPrincipal() == null) {// 表示没有登录，重定向到登录页面
			saveRequest(request);
			WebUtils.issueRedirect(request, response, LOGIN_URL);
		} else {
			if (StringUtils.hasText(UNAUTHORIZED_URL)) {// 如果有未授权页面跳转过去
				WebUtils.issueRedirect(request, response, UNAUTHORIZED_URL);
			} else {// 否则返回401未授权状态码
				WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		return false;
	}
}
