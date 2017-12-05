/**
 * @Title: ISystemMenuButtonService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:15:27
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemMenuButton;

/**
  * @ClassName: ISystemMenuButtonService
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月19日 下午8:15:27
  *
  */

public interface ISystemMenuButtonService {
	/**/
	int insert(SystemMenuButton systemMenuButton);
	
	int delete(String menuId);
	
	Set<String> findButtonByMenuId(String menuId);
}

