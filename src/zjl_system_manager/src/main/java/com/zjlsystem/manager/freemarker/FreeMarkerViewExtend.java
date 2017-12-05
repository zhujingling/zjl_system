/**
 * @Title: FreeMarkerViewExtend.java
 * @Package com.zjlsystem.manager.freemarker
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午10:42:16
 * @version V1.0
 */

package com.zjlsystem.manager.freemarker;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.zjlsystem.entity.permissions.SystemUser;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.common.Constant;
import com.zjlsystem.tool.common.LoggerUtils;

/**
 * @ClassName: FreeMarkerViewExtend
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午10:42:16
 *
 */

public class FreeMarkerViewExtend extends FreeMarkerView {

	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) {

		try {
			super.exposeHelpers(model, request);
		} catch (Exception e) {
			LoggerUtils.fmtError(FreeMarkerViewExtend.class,e, "FreeMarkerViewExtend 加载父类出现异常。请检查。");
		}
		model.put(Constant.CONTEXT_PATH, request.getContextPath());
//		model.putAll(Ferrmarker.initMap);
		SystemUser token = TokenManager.getToken();
		//String ip = IPUtils.getIP(request);
		model.put("token", token);//登录的token
		model.put("_time", new Date().getTime());
		model.put("NOW_YEAY", Constant.NOW_YEAY);//今年
		
		model.put("_v", Constant.VERSION);//版本号，重启的时间
		model.put("cdn", Constant.DOMAIN_CDN);//CDN域名


	}
}
