/**
 * @Title: SystemRoleMenuServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月24日 下午10:08:40
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemRoleMenuService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.dao.permissions.ISystemRoleMenuDao;
import com.zjlsystem.entity.permissions.SystemRoleMenu;

/**
 * @ClassName: SystemRoleMenuServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月24日 下午10:08:40
 *
 */
@Service
public class SystemRoleMenuServiceImpl extends BaseMybatisDao<ISystemRoleMenuDao> implements ISystemRoleMenuService {

	@Autowired
	ISystemRoleMenuDao systemRoleMenuDao;

	/*
	 * <p>Title: findMenuByRoleId</p> <p>Description: </p>
	 * 
	 * @param rId
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemRoleMenuService#
	 * findMenuByRoleId(java.util.Set)
	 */

	@Override
	public Set<String> findMenuByRoleId(String rId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		Set<String> result = systemRoleMenuDao.findMenuByRoleId(rId);
		return result;
	}

	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemRoleMenu
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemRoleMenuService#insert(com.
	 * zjlsystem.entity.permissions.SystemRoleMenu)
	 */

	@Override
	public int insert(SystemRoleMenu systemRoleMenu) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleMenuDao.insert(systemRoleMenu);
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
	 * com.zjlsystem.business.permissions.ISystemRoleMenuService#delete(java.
	 * lang.String)
	 */

	@Override
	public int delete(String roleId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleMenuDao.delete(roleId);
		return count;
	}

}
