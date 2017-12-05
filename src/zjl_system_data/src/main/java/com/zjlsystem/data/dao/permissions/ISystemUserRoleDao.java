package com.zjlsystem.data.dao.permissions;

import java.util.Set;

import com.zjlsystem.entity.permissions.SystemUserRole;

/**
 * @ClassName: ISystemUserRoleDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemUserRoleDao {

	int insert(SystemUserRole systemUserRole);

	int delete(String userId);

	Set<String> findRoleByUserId(String uId);
}
