package com.zjlsystem.data.dao.permissions;

import java.util.List;

import com.zjlsystem.entity.permissions.SystemRole;

/**
 * @ClassName: ISystemRoleDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemRoleDao {
	
	int insert(SystemRole systemRole);

	int delete(String roleId);

	int Update(SystemRole systemRole);
	
	SystemRole findRoleByRoleId(String roleId);
	
	List<SystemRole> getAllRole();
}
