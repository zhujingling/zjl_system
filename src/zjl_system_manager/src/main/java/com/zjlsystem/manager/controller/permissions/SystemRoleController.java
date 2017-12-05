/**
 * @Title: SystemRoleController.java
 * @Package com.zjlsystem.manager.controller.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月30日 下午7:34:08
 * @version V1.0
 */

package com.zjlsystem.manager.controller.permissions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import com.zjlsystem.business.permissions.ISystemButtonService;
import com.zjlsystem.business.permissions.ISystemMenuButtonService;
import com.zjlsystem.business.permissions.ISystemMenuService;
import com.zjlsystem.business.permissions.ISystemRoleMenuButtonService;
import com.zjlsystem.business.permissions.ISystemRoleMenuService;
import com.zjlsystem.business.permissions.ISystemRoleService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.common.ZTreeNode;
import com.zjlsystem.entity.permissions.SystemButton;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.entity.permissions.SystemRole;
import com.zjlsystem.entity.permissions.SystemRoleMenu;
import com.zjlsystem.entity.permissions.SystemRoleMenuButton;
import com.zjlsystem.entity.permissions.SystemUser;
import com.zjlsystem.manager.base.BaseController;
import com.zjlsystem.shiro.token.TokenManager;
import com.zjlsystem.tool.controller.ResponseConstant;

/**
 * @ClassName: SystemRoleController
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月30日 下午7:34:08
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/permissions/systemrole")
public class SystemRoleController extends BaseController {

	@Autowired
	ISystemRoleService systemRoleService;
	@Autowired
	ISystemButtonService systemButtonService;
	@Autowired
	ISystemUserRoleService systemUserRoleService;
	@Autowired
	ISystemMenuService systemMenuService;
	@Autowired
	ISystemMenuButtonService systemMenuButtonService;
	@Autowired
	ISystemRoleMenuService systemRoleMenuService;
	@Autowired
	ISystemRoleMenuButtonService systemRoleMenuButtonService;

	@ResponseBody
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index(String menuId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("menuId", menuId);
		modelAndView.setViewName("permissions/role/index");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "role_add", method = RequestMethod.GET)
	public ModelAndView roleAddView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("permissions/role/role_add");
		return modelAndView;

	}

	@ResponseBody
	@RequestMapping(value = "findrolebypage", method = RequestMethod.POST)
	public String findRoleByPage(String findContent, ModelMap modelMap, Integer pageNo, Integer pageSize) {
		modelMap.put("findContent", findContent);
		Pagination<SystemRole> systemRoles = systemRoleService.findByPage(modelMap, pageNo, pageSize);
		int count = systemRoles.getTotalCount();
		modelMap.addAttribute("total", count);
		modelMap.addAttribute("rows", systemRoles.getList());
		String result = new Gson().toJson(modelMap);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(SystemRole systemRole) {

		// `id`, `role_name`, `role_type`, `role_code`, `orderno`, `createtime`,
		// `modifytime`, `createman`
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		systemRole.setId(UUID.randomUUID().toString());
		systemRole.setCreateTime(sdf.format(new Date()));
		systemRole.setCreateMan(TokenManager.getUserRealName());
		int count = systemRoleService.insert(systemRole);
		String result;
		if (count > 0) {
			result = ResponseConstant.ResponseSuccess(ResponseConstant.ROLEINSERTSUCCESS);
			return result;
		}
		return ResponseConstant.ResponseSuccess(ResponseConstant.ROLEINSERTFAILURE);
	}

	@ResponseBody
	@RequestMapping(value = "allocationmenubuttontorole", method = RequestMethod.POST)
	public String allocationMenuButtonToRole(String rId, String data) {
		int countMenuSuccess = 0, countMenuFailure = 0, countButtonSuccess = 0, countButtonFailure = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonArray jAData = new Gson().fromJson(data, JsonArray.class);
		// 把数据表里面的数据全删除再分配
		systemRoleMenuService.delete(rId);
		systemRoleMenuButtonService.delete(rId);

		for (JsonElement jsonElement : jAData) {
			JsonObject jOData = jsonElement.getAsJsonObject();
			// 菜单的
			if (jOData.get("isMenu").getAsBoolean()) {
				SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
				systemRoleMenu.setId(UUID.randomUUID().toString());
				systemRoleMenu.setCreateMan(TokenManager.getUserRealName());
				systemRoleMenu.setCreateTime(sdf.format(new Date()));
				systemRoleMenu.setMenuId(jOData.get("id").getAsString());
				systemRoleMenu.setRoleId(rId);
				systemRoleMenu.setRemarks("无");
				int count = systemRoleMenuService.insert(systemRoleMenu);
				if (count > 0) {
					countMenuSuccess += count;
				} else {
					countMenuFailure += count;
				}
			} else {
				SystemRoleMenuButton systemRoleMenuButton = new SystemRoleMenuButton();
				systemRoleMenuButton.setId(UUID.randomUUID().toString());
				systemRoleMenuButton.setRoleId(rId);
				systemRoleMenuButton.setMenuId(jOData.get("pId").getAsString());
				systemRoleMenuButton.setButtonId(jOData.get("id").getAsString());
				systemRoleMenuButton.setCreateMan(TokenManager.getUserRealName());
				systemRoleMenuButton.setCreateTime(sdf.format(new Date()));
				systemRoleMenuButton.setRemarks("无");
				int count = systemRoleMenuButtonService.insert(systemRoleMenuButton);
				if (count > 0) {
					countButtonSuccess += count;
				} else {
					countButtonFailure += count;
				}
			}
		}
		String resultData = "分配菜单成功数：" + countMenuSuccess + ",分配菜单失败数:" + countMenuFailure + ";" + "分配按钮成功数："
				+ countButtonSuccess + ",分配按钮失败数:" + countButtonFailure;
		return ResponseConstant.ResponseSuccess(resultData);
	}

	@ResponseBody
	@RequestMapping(value = "getrolemenubutton", method = RequestMethod.POST)
	public String getRoleMenuButton(String menuId) {
		Set<String> menuButtonIds = new HashSet<String>();
		// 查找菜单
		Set<String> rIds = systemUserRoleService.findRoleByUserId(TokenManager.getUserId());
		Set<String> menuButtons = new HashSet<String>();
		for (String rId : rIds) {
			menuButtons.addAll(systemRoleMenuButtonService.findButtonByRidAndMenuId(rId, menuId));
		}
		// Set<String> menuButtons =
		// systemMenuButtonService.findButtonByMenuId(menuId);
		if (menuButtons.size() > 0) {
			menuButtonIds.addAll(menuButtons);
		}
		List<SystemButton> buttonList = new ArrayList<SystemButton>();
		for (String buttonId : menuButtonIds) {
			SystemButton systemButton = systemButtonService.findButtonByButtonId(buttonId);
			buttonList.add(systemButton);
		}
		// 排序
		Collections.sort(buttonList, new Comparator<SystemButton>() {
			public int compare(SystemButton o1, SystemButton o2) {
				return o1.getOrderNo() - o2.getOrderNo();
			}
		});
		return new Gson().toJson(buttonList);
	}

	@ResponseBody
	@RequestMapping(value = "getrolemenu", method = RequestMethod.GET)
	public String getRoleMenu(String roleId) {

		List<SystemMenu> menuListAll = systemMenuService.findAllMenu();
		List<SystemButton> buttonList;

		Set<String> menuIds = systemRoleMenuService.findMenuByRoleId(roleId);

		Map<String, Set<String>> menuButtonMap = new HashMap<String, Set<String>>();
		Map<String, List<SystemButton>> menuButtonListMap = new HashMap<String, List<SystemButton>>();
		// 查找菜单下的按钮id
		for (String menuId : menuIds) {
			// 该角色下该菜单拥有的按钮
			Set<String> roleOwnerMenuButton = systemRoleMenuButtonService.findButtonByRidAndMenuId(roleId, menuId);
			Set<String> menuButtons = systemMenuButtonService.findButtonByMenuId(menuId);
			buttonList = new ArrayList<SystemButton>();
			for (String buttonId : menuButtons) {
				buttonList.add(systemButtonService.findButtonByButtonId(buttonId));
			}
			menuButtonListMap.put(menuId, buttonList);
			menuButtonMap.put(menuId, roleOwnerMenuButton);
		}
		List<ZTreeNode> result = getRoleMenuButtonZTree(menuListAll, menuButtonListMap, menuIds, menuButtonMap);
		return new Gson().toJson(result);
	}

	public List<ZTreeNode> getRoleMenuButtonZTree(List<SystemMenu> menuListAll,
			Map<String, List<SystemButton>> menuButtonListMap, Set<String> menuIds,
			Map<String, Set<String>> menuButtonMap) {
		List<ZTreeNode> listZTreeNode = new ArrayList<ZTreeNode>();
		for (SystemMenu systemMenu : menuListAll) {
			ZTreeNode zTreeNodeMenu = new ZTreeNode();
			zTreeNodeMenu.setId(systemMenu.getId());
			zTreeNodeMenu.setName(systemMenu.getMenuName());
			zTreeNodeMenu.setpId(systemMenu.getParentId());
			zTreeNodeMenu.setChecked(menuIds.contains(systemMenu.getId()));
			zTreeNodeMenu.setIsMenu(true);
			zTreeNodeMenu.setIsOpen(true);
			listZTreeNode.add(zTreeNodeMenu);

			Set<String> roleOwnerMenuButtons = menuButtonMap.get(systemMenu.getId());
			List<SystemButton> buttonList = menuButtonListMap.get(systemMenu.getId());

			if (buttonList == null || buttonList.size() == 0) {
				buttonList = new ArrayList<SystemButton>();
				Set<String> menuButtons = systemMenuButtonService.findButtonByMenuId(systemMenu.getId());
				// 所有的一级菜单没有按钮。
				for (String buttonId : menuButtons) {
					SystemButton item = systemButtonService.findButtonByButtonId(buttonId);
					if (item != null) {
						buttonList.add(item);
					}
				}
			}
			if (buttonList.size() > 0) {
				for (SystemButton systemButton : buttonList) {
					if (systemButton == null) {
						continue;
					}
					ZTreeNode zTreeNodeButton = new ZTreeNode();
					zTreeNodeButton.setId(systemButton.getId());
					zTreeNodeButton.setName(systemButton.getButtonName());
					zTreeNodeButton.setpId(systemMenu.getId());
					zTreeNodeButton.setIsOpen(true);
					zTreeNodeButton.setIsMenu(false);
					if (roleOwnerMenuButtons == null || roleOwnerMenuButtons.size() == 0) {
						zTreeNodeButton.setChecked(false);
					} else {
						zTreeNodeButton.setChecked(roleOwnerMenuButtons.contains(systemButton.getId()));
					}

					listZTreeNode.add(zTreeNodeButton);
				}
			}

		}
		return listZTreeNode;
	}

}
