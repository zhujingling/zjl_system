/**
 * @Title: SystemButtonController.java
 * @Package com.zjlsystem.manager.ontroller.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月20日 下午7:29:58
 * @version V1.0
 */

package com.zjlsystem.manager.controller.permissions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemButtonService;
import com.zjlsystem.business.permissions.ISystemMenuButtonService;
import com.zjlsystem.business.permissions.ISystemRoleMenuButtonService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.common.ZTreeNode;
import com.zjlsystem.entity.permissions.SystemButton;
import com.zjlsystem.entity.permissions.SystemRole;
import com.zjlsystem.manager.base.BaseController;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.controller.ResponseConstant;

/**
 * @ClassName: SystemButtonController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月20日 下午7:29:58
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/permissions/systembutton")
public class SystemButtonController extends BaseController {

	@Autowired
	ISystemButtonService systemButtonService;
	@Autowired
	ISystemMenuButtonService systemMenuButtonService;

	@ResponseBody
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(String menuId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", menuId);
		modelAndView.setViewName("permissions/button/index");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "button_add", method = RequestMethod.GET)
	public ModelAndView buttonAddView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/button/button_add");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "button_ztree", method = RequestMethod.GET)
	public ModelAndView buttonZTreeView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/button/button_ztree");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "findbuttonbypage", method = RequestMethod.POST)
	public String findButtonByPage(String findContent, ModelMap modelMap, Integer pageNo, Integer pageSize) {
		modelMap.put("findContent", findContent);
		Pagination<SystemButton> systemButtons = systemButtonService.findByPage(modelMap, pageNo, pageSize);
		int count = systemButtons.getTotalCount();
		modelMap.addAttribute("total", count);
		modelMap.addAttribute("rows", systemButtons.getList());
		String result = new Gson().toJson(modelMap);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(SystemButton systemButton) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		systemButton.setId(UUID.randomUUID().toString());
		systemButton.setCreateMan(TokenManager.getUserRealName());
		systemButton.setCreateTime(date);
		int count = systemButtonService.insert(systemButton);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.BUTTONINSERTSUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.BUTTONINSERTFAILURE);
	}

	@ResponseBody
	@RequestMapping(value = "buttonztree", method = RequestMethod.GET)
	public List<ZTreeNode> buttonZTree(String menuId) {
		
		Set<String> buttonsId = getMenuButton(menuId);
		List<SystemButton> listButton = systemButtonService.getAllButton();
		List<ZTreeNode> listZTreeNode = new ArrayList<ZTreeNode>();
		for (SystemButton systemButton : listButton) {
			if (buttonsId.size() > 0 && buttonsId.contains(systemButton.getId())) {
				ZTreeNode zTreeNode = new ZTreeNode();
				zTreeNode.setId(systemButton.getId());
				zTreeNode.setName(systemButton.getButtonName());
				zTreeNode.setpId("0");
				zTreeNode.setIsOpen(true);
				zTreeNode.setChecked(true);
				listZTreeNode.add(zTreeNode);
			} else {
				ZTreeNode zTreeNode = new ZTreeNode();
				zTreeNode.setId(systemButton.getId());
				zTreeNode.setName(systemButton.getButtonName());
				zTreeNode.setpId("0");
				zTreeNode.setIsOpen(true);
				zTreeNode.setChecked(false);
				listZTreeNode.add(zTreeNode);
			}
		}
		listZTreeNode.add(ZTreeNode.createMenuParent());
		return listZTreeNode;
	}

	private Set<String> getMenuButton(String menuId) {
		Set<String> buttonsResult = systemMenuButtonService.findButtonByMenuId(menuId);
		return buttonsResult;

	}

}
