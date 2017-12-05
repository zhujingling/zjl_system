/**
 * @Title: ISystemRoleService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:16:08
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.List;
import java.util.Map;

import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.entity.permissions.SystemRole;

/**
  * @ClassName: ISystemRoleService
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月19日 下午8:16:08
  *
  */

public interface ISystemRoleService {
	
	int insert(SystemRole systemRole);
	
	int delete(String roleId);
	
	int Update(SystemRole systemRole);
	
	Pagination<SystemRole> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	
	SystemRole findRoleByRoleId(String roleId);
	
	List<SystemRole> getAllRole();

}
