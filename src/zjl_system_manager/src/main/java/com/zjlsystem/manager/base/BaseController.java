/**
 * @Title: BaseController.java
 * @Package com.zjlsystem.manager.base
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月24日 下午7:27:50
 * @version V1.0
 */

package com.zjlsystem.manager.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zjlsystem.tool.common.StringUtils;

/**
 * @ClassName: BaseController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月24日 下午7:27:50
 *
 */

public class BaseController {
	protected int pageNo = 1;
	public static int pageSize = 10;
	protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
	public static String URL404 = "/404.html";

	private final static String PARAM_PAGE_NO = "pageNo";

	protected String pageSizeName = "pageSize";

	/*
	 * 
	 * @param request
	 * 
	 * @param key
	 * 
	 * @param value
	 */
	protected static void setValue2Request(HttpServletRequest request, String key, Object value) {
		request.setAttribute(key, value);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		BaseController.pageSize = pageSize;
	}

	public ModelAndView redirect(String redirectUrl, Map<String, Object>... parament) {
		ModelAndView view = new ModelAndView(new RedirectView(redirectUrl));
		if (null != parament && parament.length > 0) {
			view.addAllObjects(parament[0]);
		}
		return view;
	}

	public ModelAndView redirect404() {
		return new ModelAndView(new RedirectView(URL404));
	}

	@SuppressWarnings("unchecked")
	protected Map<String, String> prepareParams(Object obj, HttpServletRequest request) throws Exception {
		if (request != null) {
			String pageNoStr = (String) request.getParameter(PARAM_PAGE_NO),
					pageSizeStr = (String) request.getParameter(pageSizeName);
			if (StringUtils.isNotBlank(pageNoStr)) {
				pageNo = Integer.parseInt(pageNoStr);
			}
			if (StringUtils.isNotBlank(pageSizeStr)) {
				pageSize = Integer.parseInt(pageSizeStr);
			}
		}

		Map<String, String> params = new HashMap<String, String>();
		params = BeanUtils.describe(obj);
		params = handleParams(params);
		// 回填值项
		// BeanUtils.populate(obj, params);
		return params;
	}

	private Map<String, String> handleParams(Map<String, String> params) {
		Map<String, String> result = new HashMap<String, String>();
		if (null != params) {
			Set<Entry<String, String>> entrySet = params.entrySet();

			for (Iterator<Entry<String, String>> it = entrySet.iterator(); it.hasNext();) {
				Entry<String, String> entry = it.next();
				if (entry.getValue() != null) {
					result.put(entry.getKey(), StringUtils.trimToEmpty((String) entry.getValue()));
				}
			}
		}
		return result;
	}
	
	
	protected String ResponseSuccess() {
		return null;
	}
}
