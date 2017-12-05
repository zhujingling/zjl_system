/**
 * @Title: SystemMenuController.java
 * @Package com.zjlsystem.manager.controller.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月30日 下午7:34:24
 * @version V1.0
 */

package com.zjlsystem.manager.controller.permissions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.zjlsystem.business.permissions.ISystemMenuButtonService;
import com.zjlsystem.business.permissions.ISystemMenuService;
import com.zjlsystem.business.permissions.ISystemRoleMenuButtonService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.permissions.SystemButton;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.entity.permissions.SystemMenuButton;
import com.zjlsystem.entity.permissions.SystemRoleMenuButton;
import com.zjlsystem.manager.base.BaseController;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.controller.ResponseConstant;

/**
 * @ClassName: SystemMenuController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月30日 下午7:34:24
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/permissions/systemmenu")
public class SystemMenuController extends BaseController {

	@Autowired
	ISystemMenuService systemMenuService;
	@Autowired
	ISystemMenuButtonService systemMenuButtonService;
	@Autowired
	ISystemUserRoleService systemUserRoleService;

	@ResponseBody
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(String menuId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", menuId);
		modelAndView.setViewName("permissions/menu/index");
		return modelAndView;

	}
	
	@ResponseBody
	@RequestMapping(value = "menu_ztree", method = RequestMethod.GET)
	public ModelAndView buttonZTreeView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/menu/menu_ztree");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "menu_add", method = RequestMethod.GET)
	public ModelAndView roleAddView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/menu/menu_add");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "findmenubypage", method = RequestMethod.POST)
	public Object findMenuByPage(String findContent, ModelMap modelMap) {
		modelMap.put("findContent", findContent);
		List<SystemMenu> systemButtons = systemMenuService.findAllMenu();
		return systemButtons;
	}

	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(SystemMenu systemMenu) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// `id`, `menu_name`, `menu_url`, `parentid`, `icon`, `orderno`,
		// `levels`, `remarks`, `createtime`, `modifytime`, `createman`
		systemMenu.setId(UUID.randomUUID().toString());
		systemMenu.setCreateTime(sdf.format(new Date()));
		systemMenu.setCreateMan(TokenManager.getUserRealName());

		int count = systemMenuService.insert(systemMenu);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.MENUINSERTSUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.MENUINSERTFAILURE);
	}

	/*
	 * 给角色分配菜单的操作
	 */
	@ResponseBody
	@RequestMapping(value = "allocationrolemenubutton", method = RequestMethod.POST)
	public String allocationRoleMenuButton(String menuId, String buttonsId) {
		int countSuccess = 0, countFailure = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] strButtonsId = buttonsId.split(",");
		// 先删除该角色下该菜单的所有按钮
		systemMenuButtonService.delete(menuId);
		for (String buttonId : strButtonsId) {

			SystemMenuButton systemMenuButton = new SystemMenuButton();
			systemMenuButton.setId(UUID.randomUUID().toString());
			systemMenuButton.setMenuId(menuId);
			systemMenuButton.setButtonId(buttonId);
			systemMenuButton.setCreateMan(TokenManager.getUserRealName());
			systemMenuButton.setCreateTime(sdf.format(new Date()));
			systemMenuButton.setRemarks("无⃣️");
			int count = systemMenuButtonService.insert(systemMenuButton);
			// 分配成功个数
			if (count > 0) {
				countSuccess += count;
			} else {
				countFailure += count;
			}
		}

		String resultData = "分配按钮成功数：" + countSuccess + ",分配按钮失败数:" + countFailure;
		return ResponseConstant.ResponseSuccess(resultData);
	}

	@ResponseBody
	@RequestMapping(value = "getmenuztreenode", method = RequestMethod.POST)
	public String GetMenuZTreeNode() {
		return null;
	}

}
