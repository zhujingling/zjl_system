package com.zjlsystem.data.dao.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemRoleMenu;

/**
 * @ClassName: ISystemRoleMenuDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemRoleMenuDao {
	
	int insert(SystemRoleMenu systemRoleMenu);

	int delete(String roleId);

	Set<String> findMenuByRoleId(String rId);
}
