/**
 * @Title: SystemUserController.java
 * @Package com.zjlsystem.manager.controller.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月24日 下午7:25:17
 * @version V1.0
 */

package com.zjlsystem.manager.controller.permissions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zjlsystem.business.permissions.ISystemRoleService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.business.permissions.ISystemUserService;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.common.ZTreeNode;
import com.zjlsystem.entity.permissions.SystemButton;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.entity.permissions.SystemRole;
import com.zjlsystem.entity.permissions.SystemUser;
import com.zjlsystem.entity.permissions.SystemUserRole;
import com.zjlsystem.manager.base.BaseController;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.common.LoggerUtils;
import com.zjlsystem.tool.common.StringUtils;
import com.zjlsystem.tool.controller.ResponseConstant;

/**
 * @ClassName: SystemUserController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月24日 下午7:25:17
 *
 */
@Controller
@RequestMapping("/permissions/systemuser")
public class SystemUserController extends BaseController {

	@Autowired
	ISystemUserService systemUserService;
	@Autowired
	ISystemUserRoleService systemUserRoleService;
	@Autowired
	ISystemRoleService systemRoleService;

	@ResponseBody
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(String menuId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", menuId);
		modelAndView.setViewName("permissions/user/index");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "user_add", method = RequestMethod.GET)
	public ModelAndView userAddView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/user/user_add");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "userrole", method = RequestMethod.GET)
	public ModelAndView roleAddView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/user/user_allocation_role");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "finduserbypage", method = RequestMethod.POST)
	public String findUserByPage(String findContent, ModelMap modelMap, Integer pageNo, Integer pageSize) {
		modelMap.put("findContent", findContent);
		Pagination<SystemUser> systemUsers = systemUserService.findByPage(modelMap, pageNo, pageSize);
		int count = systemUsers.getTotalCount();
		modelMap.addAttribute("total", count);
		modelMap.addAttribute("rows", systemUsers.getList());
		String result = new Gson().toJson(modelMap);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(SystemUser systemUser) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		systemUser.setId(UUID.randomUUID().toString());

		systemUser.setCreateTime(sdf.format(new Date()));
		systemUser.setCreateMan(TokenManager.getUserRealName());
		systemUser.setStatus(SystemUser._1);

		int count = systemUserService.insert(systemUser);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERINSERTSUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.USERINSERTFAILURE);
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(String uId) {
		int count = systemUserService.delete(uId);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERDELETESUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.USERDELETEFAILURE);
	}

	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(SystemUser systemUser) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		systemUser.setModifyTime(sdf.format(new Date()));
		int count = systemUserService.update(systemUser);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERUPDATESUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.USERUPDATEFAILURE);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String submitLogin(String userAccount, String passWord, Boolean rememberMe, HttpServletRequest request) {
		String result;
		try {
			SystemUser systemUser = new SystemUser();
			systemUser.setUserAccount(userAccount);
			systemUser.setUserPassword(passWord);

			systemUser = TokenManager.login(systemUser, rememberMe);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");

			// 获取用户未登录之前的地址
			String url = (String) request.getAttribute(WebUtils.FORWARD_REQUEST_URI_ATTRIBUTE);
			LoggerUtils.fmtDebug(getClass(), "获取登录之前的URL:[%s]", url);
			// 如果登录之前没有地址，那么就跳转到首页。
			if (StringUtils.isBlank(url)) {
				url = "/system/login.shtml";
			}
			result = ResponseConstant.ResponseSuccess(ResponseConstant.USERLOGINSUCCESS, systemUser);

		} catch (DisabledAccountException e) {
			result = ResponseConstant.ResponseFailure(ResponseConstant.USERFORBID);
		} catch (Exception e) {
			result = ResponseConstant.ResponseFailure(ResponseConstant.USERACCOUNTORPWDERROR);
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "getuserrole", method = RequestMethod.GET)
	public String getUserRole(String uId) {
		Set<String> rIds = systemUserRoleService.findRoleByUserId(uId);
		List<SystemRole> roleList = systemRoleService.getAllRole();
		List<ZTreeNode> listZTreeNode = new ArrayList<ZTreeNode>();
		for (SystemRole systemRole : roleList) {
			ZTreeNode zTreeNode = new ZTreeNode();
			zTreeNode.setId(systemRole.getId());
			zTreeNode.setName(systemRole.getRoleName());
			zTreeNode.setpId("0");
			zTreeNode.setChecked(rIds.contains(systemRole.getId()));
			zTreeNode.setIsOpen(true);
			listZTreeNode.add(zTreeNode);
		}
		return new Gson().toJson(listZTreeNode);
	}

	@ResponseBody
	@RequestMapping(value = "allocationroletouser", method = RequestMethod.POST)
	public String allocationRoleToUser(String uId, String data) {
		int countRoleSuccess = 0,countRoleFailure=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonArray jAData = new Gson().fromJson(data, JsonArray.class);
		// 把数据表里面的数据全删除再分配
		systemUserRoleService.delete(uId);
		for (JsonElement jsonElement : jAData) {
			JsonObject jOData = jsonElement.getAsJsonObject();
			// 菜单的
			SystemUserRole systemUserRole = new SystemUserRole();
			systemUserRole.setId(UUID.randomUUID().toString());
			systemUserRole.setUserId(uId);
			systemUserRole.setRoleId(jOData.get("id").getAsString());
			systemUserRole.setRemarks("无");
			systemUserRole.setCreateMan(TokenManager.getUserRealName());
			systemUserRole.setCreateTime(sdf.format(new Date()));
			int count = systemUserRoleService.insert(systemUserRole);
			if (count > 0) {
				countRoleSuccess += count;
			} else {
				countRoleFailure += count;
			}
		}

		String resultData = "分配角色成功数：" + countRoleSuccess + ",分配角色失败数:" + countRoleFailure ;
		return ResponseConstant.ResponseSuccess(resultData);
	}

}
