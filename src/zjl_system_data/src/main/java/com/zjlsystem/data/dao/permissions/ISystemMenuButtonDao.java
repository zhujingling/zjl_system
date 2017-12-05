package com.zjlsystem.data.dao.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemMenuButton;

/**
 * @ClassName: ISystemMenuButtonDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemMenuButtonDao {
	/**/
	int insert(SystemMenuButton systemMenuButton);

	int delete(String menuId);
	
	Set<String> findButtonByMenuId(String menuId);
}
