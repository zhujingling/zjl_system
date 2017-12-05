/**
 * @Title: ISystemRoleMenuService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:16:31
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemRoleMenu;

/**
 * @ClassName: ISystemRoleMenuService
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:16:31
 *
 */

public interface ISystemRoleMenuService {
	
	int insert(SystemRoleMenu systemRoleMenu);
	
	int delete(String roleId);
	
	Set<String> findMenuByRoleId(String rId);

}
