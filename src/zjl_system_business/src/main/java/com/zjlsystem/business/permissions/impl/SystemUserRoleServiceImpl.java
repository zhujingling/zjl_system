/**
 * @Title: SystemUserRoleServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月24日 下午9:52:44
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemButtonService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.data.dao.permissions.ISystemButtonDao;
import com.zjlsystem.data.dao.permissions.ISystemUserRoleDao;
import com.zjlsystem.entity.permissions.SystemButton;
import com.zjlsystem.entity.permissions.SystemUserRole;

/**
 * @ClassName: SystemUserRoleServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月24日 下午9:52:44
 *
 */
@Service
public class SystemUserRoleServiceImpl extends BaseMybatisDao<ISystemUserRoleDao> implements ISystemUserRoleService {

	@Autowired
	ISystemUserRoleDao systemUserRoleDao;
	/*
	 * <p>Title: findRoleByUserId</p> <p>Description: </p>
	 * 
	 * @param uId
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemUserRoleService#
	 * findRoleByUserId(java.lang.String)
	 */

	@Override
	public Set<String> findRoleByUserId(String uId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		Set<String> result = systemUserRoleDao.findRoleByUserId(uId);
		return result;
	}

	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemUserRole
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemUserRoleService#insert(com.
	 * zjlsystem.entity.permissions.SystemUserRole)
	 */

	@Override
	public int insert(SystemUserRole systemUserRole) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemUserRoleDao.insert(systemUserRole);
		return count;
	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param userId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemUserRoleService#delete(java.
	 * lang.String)
	 */

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemUserRoleDao.delete(userId);
		return count;
	}

}
