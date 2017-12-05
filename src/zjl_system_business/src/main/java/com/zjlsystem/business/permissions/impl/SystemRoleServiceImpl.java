/**
 * @Title: SystemRoleServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月26日 下午7:44:46
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemRoleService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.data.dao.permissions.ISystemRoleDao;
import com.zjlsystem.entity.permissions.SystemMenu;
import com.zjlsystem.entity.permissions.SystemRole;

/**
 * @ClassName: SystemRoleServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月26日 下午7:44:46
 *
 */
@Service
public class SystemRoleServiceImpl extends BaseMybatisDao<ISystemRoleDao> implements ISystemRoleService {

	@Autowired
	ISystemRoleDao systemRoleDao;
	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemRole
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemRoleService#insert(com.
	 * zjlsystem.entity.permissions.SystemRole)
	 */

	@Override
	public int insert(SystemRole systemRole) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleDao.insert(systemRole);
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
	 * com.zjlsystem.business.permissions.ISystemRoleService#delete(java.lang.
	 * String)
	 */

	@Override
	public int delete(String roleId) {
		// TODO Auto-generated method stub
		int count = systemRoleDao.delete(roleId);
		return count;
	}

	/*
	 * <p>Title: Update</p> <p>Description: </p>
	 * 
	 * @param systemRole
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemRoleService#Update(com.
	 * zjlsystem.entity.permissions.SystemRole)
	 */

	@Override
	public int Update(SystemRole systemRole) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemRoleDao.Update(systemRole);
		return count;
	}

	/*
	 * <p>Title: findByPage</p> <p>Description: </p>
	 * 
	 * @param resultMap
	 * 
	 * @param pageNo
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemRoleService#findByPage(java.
	 * util.Map, java.lang.Integer, java.lang.Integer)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SystemRole> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		return super.findPage(resultMap, pageNo, pageSize);
	}

	/*
	 * <p>Title: findRoleByRoleId</p> <p>Description: </p>
	 * 
	 * @param roleId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemRoleService#findRoleByRoleId(
	 * java.lang.String)
	 */

	@Override
	public SystemRole findRoleByRoleId(String roleId) {
		// TODO Auto-generated method stub
		SystemRole result = systemRoleDao.findRoleByRoleId(roleId);
		return result;
	}

	/*
	  * <p>Title: getAllRole</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.zjlsystem.business.permissions.ISystemRoleService#getAllRole()
	  */
	
	
	@Override
	public List<SystemRole> getAllRole() {
		// TODO Auto-generated method stub
		List<SystemRole> result=systemRoleDao.getAllRole();
		return result;
	}

}
