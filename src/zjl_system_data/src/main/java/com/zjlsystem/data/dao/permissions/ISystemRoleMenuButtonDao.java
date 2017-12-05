package com.zjlsystem.data.dao.permissions;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.zjlsystem.entity.permissions.SystemRoleMenuButton;

/**
 * @ClassName: ISystemRoleMenuButtonDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemRoleMenuButtonDao {

	int insert(SystemRoleMenuButton systemRoleMenuButton);

	int delete(String roleId);

	Set<String> findButtonByRidAndMenuId(@Param("roleId")String roleId, @Param("menuId")String menuId);
}
