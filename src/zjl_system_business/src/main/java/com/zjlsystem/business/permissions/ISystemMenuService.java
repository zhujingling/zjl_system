/**
 * @Title: ISystemMenuService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:15:55
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.List;
import java.util.Map;

import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.permissions.SystemMenu;

/**
  * @ClassName: ISystemMenuService
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月19日 下午8:15:55
  *
  */

public interface ISystemMenuService {
	
	int insert(SystemMenu systemMenu);
	
	int delete(String menuId);
	
	int update(SystemMenu systemMenu);
	
	Pagination<SystemMenu> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	
	SystemMenu findMenuByMenuId(String menuId);
	
	List<SystemMenu> findAllMenu();
}

