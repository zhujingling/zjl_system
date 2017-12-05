/**
 * @Title: ISystemRoleMenuButtonService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:16:18
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemRoleMenuButton;

/**
  * @ClassName: ISystemRoleMenuButtonService
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月19日 下午8:16:18
  *
  */

public interface ISystemRoleMenuButtonService {
	
	int insert(SystemRoleMenuButton systemRoleMenuButton);
	
	int delete(String roleId);
	
	Set<String> findButtonByRidAndMenuId(String roleId,String menuId);
	
}
