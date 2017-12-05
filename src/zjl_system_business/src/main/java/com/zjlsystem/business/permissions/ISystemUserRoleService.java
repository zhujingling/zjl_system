/**
 * @Title: ISystemUserRoleService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:17:32
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemUserRole;

/**
 * @ClassName: ISystemUserRoleService
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:17:32
 *
 */

public interface ISystemUserRoleService {
	
	int insert(SystemUserRole systemUserRole);
	
	int delete(String userId);
	
	Set<String> findRoleByUserId(String uId);
}
