package com.zjlsystem.data.dao.permissions;

import java.util.List;

import com.zjlsystem.entity.permissions.SystemMenu;

/**
 * @ClassName: ISystemMenuDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemMenuDao {

	int insert(SystemMenu systemMenu);

	int delete(String menuId);

	int update(SystemMenu systemMenu);

	SystemMenu findMenuByMenuId(String menuId);
	
	List<SystemMenu> findAllMenu();
}
