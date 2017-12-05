/**
 * @Title: SystemController.java
 * @Package com.zjlsystem.manager.controller.system
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月25日 下午8:59:01
 * @version V1.0
 */

package com.zjlsystem.manager.controller.system;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import com.zjlsystem.business.permissions.ISystemMenuService;
import com.zjlsystem.business.permissions.ISystemRoleMenuService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.manager.base.BaseController;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.common.LoggerUtils;
import com.zjlsystem.tool.common.StringUtils;
import com.zjlsystem.tool.common.VerifyCodeUtils;
import com.zjlsystem.tool.controller.ResponseConstant;
import com.zjlsystem.tool.verifycode.Captcha;
import com.zjlsystem.tool.verifycode.GifCaptcha;
import com.zjlsystem.tool.verifycode.SpecCaptcha;

/**
 * @ClassName: SystemController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月25日 下午8:59:01
 *
 */

@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {

	@Autowired
	ISystemMenuService systemMenuService;
	@Autowired
	ISystemUserRoleService systemUserRoleService;
	@Autowired
	ISystemRoleMenuService systemRoleMenuService;

	@ResponseBody
	@RequestMapping(value = "login")
	public ModelAndView loginIndex() {
		return new ModelAndView("system/login");
	}

	@ResponseBody
	@RequestMapping(value = "index")
	public ModelAndView systemIndex() {
		Set<String> rIds = systemUserRoleService.findRoleByUserId(TokenManager.getUserId());
		Set<String> menuIds = new HashSet<String>();
		for (String rId : rIds) {
			Set<String> items = systemRoleMenuService.findMenuByRoleId(rId);
			if (items.size() > 0) {
				menuIds.addAll(items);
			}
		}
		List<SystemMenu> menusList = new ArrayList<SystemMenu>();
		for (String menuId : menuIds) {
			SystemMenu systemMenu = systemMenuService.findMenuByMenuId(menuId);
			menusList.add(systemMenu);
		}
		// List<SystemMenu> menusList = systemMenuService.findAllMenu();
		List<SystemMenu> menus = SystemMenu.buildTitle(menusList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menus", menus);
		modelAndView.setViewName("system/index");
		return modelAndView;
	}

	/*
	 * 404错误
	 * 
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping("404")
	public ModelAndView error404(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("system/error_404");
		return view;
	}

	/*
	 * 500错误
	 * 
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping("500")
	public ModelAndView error500(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("system/error_500");

		Throwable t = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String defaultMessage = "未知";
		if (null == t) {
			view.addObject("line", defaultMessage);
			view.addObject("clazz", defaultMessage);
			view.addObject("methodName", defaultMessage);
			return view;
		}
		String message = t.getMessage();// 错误消息
		StackTraceElement[] stack = t.getStackTrace();
		view.addObject("message", message);
		if (null != stack && stack.length != 0) {
			StackTraceElement element = stack[0];
			int line = element.getLineNumber();// 错误行号
			String clazz = element.getClassName();// 错误java类
			String fileName = element.getFileName();

			String methodName = element.getMethodName();// 错误方法
			view.addObject("line", line);
			view.addObject("clazz", clazz);
			view.addObject("methodName", methodName);
			LoggerUtils.fmtError(getClass(), "line:%s,clazz:%s,fileName:%s,methodName:%s()", line, clazz, fileName,
					methodName);
		}
		return view;
	}

	/*
	 * 获取验证码
	 * 
	 * @param response
	 */
	@RequestMapping(value = "getVCode", method = RequestMethod.GET)
	public void getVCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpg");

			// 生成随机字串
			String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
			// 存入Shiro会话session
			TokenManager.setVal2Session(VerifyCodeUtils.V_CODE, verifyCode.toLowerCase());
			// 生成图片
			int w = 146, h = 33;
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "获取验证码异常：%s", e.getMessage());
		}
	}

	/*
	 * 获取验证码（Gif版本）
	 * 
	 * @param response
	 */
	@RequestMapping(value = "getGifCode", method = RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/*
			 * gif格式动画验证码 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146, 42, 4);
			// 输出
			ServletOutputStream out = response.getOutputStream();
			captcha.out(out);
			out.flush();
			// 存入Shiro会话session
			System.out.println(captcha.text().toLowerCase());
			TokenManager.setVal2Session(VerifyCodeUtils.V_CODE, captcha.text().toLowerCase());
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "获取验证码异常：%s", e.getMessage());
		}
	}

	/*
	 * 获取验证码（jpg版本）
	 * 
	 * @param response
	 */
	@RequestMapping(value = "getJPGCode", method = RequestMethod.GET)
	public void getJPGCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpg");
			/*
			 * jgp格式验证码 宽，高，位数。
			 */
			Captcha captcha = new SpecCaptcha(146, 33, 4);
			// 输出
			captcha.out(response.getOutputStream());
			HttpSession session = request.getSession(true);
			// 存入Session
			session.setAttribute("_code", captcha.text().toLowerCase());
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "获取验证码异常：%s", e.getMessage());
		}
	}

	/*
	 * 跳转到其他网站
	 * 
	 * @param url
	 * 
	 * @return
	 */
	@RequestMapping(value = "system/goto", method = RequestMethod.GET)
	public ModelAndView _goto(String url) {

		return new ModelAndView("www/go_to", "url", url);
	}

	/*
	 * 踢出页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "kickedOut", method = RequestMethod.GET)
	public ModelAndView kickedOut(HttpServletRequest request, UrlPathHelper pp) {
		// 如果是踢出后，来源地址是：http://localhost:8082/bh_system_manager/u/login.shtml;JSESSIONID=4f1538d9-df19-48c8-b4b1-aadacadde23a
		// 如果来源是null，那么就重定向到首页。这个时候，如果首页是要登录，那就会跳转到登录页
		if (StringUtils.isBlank(request.getHeader("Referer"))) {
			return redirect("/");
		}
		return new ModelAndView("system/kicked_out");
	}

	/*
	 * 没有权限提示页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "unauthorized", method = RequestMethod.GET)
	public ModelAndView unauthorized() {
		return new ModelAndView("system/unauthorized");
	}

	@RequestMapping(value = "shiro", method = RequestMethod.GET)
	public ModelAndView shiro() {
		return new ModelAndView("shiro");
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout() {
		String result;
		try {

			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERLOGOUTSUCCESS);
			TokenManager.logout();
		} catch (Exception e) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERLOGOUTFAILURE);
			LoggerUtils.error(getClass(), e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}