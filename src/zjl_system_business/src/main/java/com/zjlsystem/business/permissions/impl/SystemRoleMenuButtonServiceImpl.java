/**
 * @Title: SystemRoleMenuButtonServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月26日 下午7:44:09
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemRoleMenuButtonService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.dao.permissions.ISystemRoleMenuButtonDao;
import com.zjlsystem.entity.permissions.SystemRoleMenuButton;

/**
 * @ClassName: SystemRoleMenuButtonServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月26日 下午7:44:09
 *
 */
@Service
public class SystemRoleMenuButtonServiceImpl extends BaseMybatisDao<ISystemRoleMenuButtonDao>
		implements ISystemRoleMenuButtonService {

	@Autowired
	ISystemRoleMenuButtonDao systemRoleMenuButtonDao;
	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemRoleMenuButton
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemRoleMenuButtonService#insert(
	 * com.zjlsystem.entity.permissions.SystemRoleMenuButton)
	 */

	@Override
	public int insert(SystemRoleMenuButton systemRoleMenuButton) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleMenuButtonDao.insert(systemRoleMenuButton);
		return count;
	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param roleId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemRoleMenuButtonService#delete(
	 * java.lang.String)
	 */

	@Override
	public int delete(String roleId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleMenuButtonDao.delete(roleId);
		return count;
	}

	/*
	 * <p>Title: findButtonByRidAndMenuId</p> <p>Description: </p>
	 * 
	 * @param roleId
	 * 
	 * @param menuId
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemRoleMenuButtonService#
	 * findButtonByRidAndMenuId(java.lang.String, java.lang.String)
	 */

	@Override
	public Set<String> findButtonByRidAndMenuId(String roleId, String menuId) {
		// TODO Auto-generated method stub
		Set<String> result = systemRoleMenuButtonDao.findButtonByRidAndMenuId(roleId, menuId);
		return result;
	}

	/*
	  * <p>Title: findButtonByRidAndMenuId</p>
	  * <p>Description: </p>
	  * @param roleId
	  * @return
	  * @see com.zjlsystem.business.permissions.ISystemRoleMenuButtonService#findButtonByRidAndMenuId(java.lang.String)
	  */
	
	

}
