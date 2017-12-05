/**
 * @Title: SystemMenuButtonServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月26日 下午7:43:34
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemMenuButtonService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.dao.permissions.ISystemMenuButtonDao;
import com.zjlsystem.entity.permissions.SystemMenuButton;

/**
 * @ClassName: SystemMenuButtonServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月26日 下午7:43:34
 *
 */
@Service
public class SystemMenuButtonServiceImpl extends BaseMybatisDao<ISystemMenuButtonDao>
		implements ISystemMenuButtonService {

	@Autowired
	ISystemMenuButtonDao systemMenuButtonDao;
	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemMenuButton
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemMenuButtonService#insert(com.
	 * zjlsystem.entity.permissions.SystemMenuButton)
	 */

	@Override
	public int insert(SystemMenuButton systemMenuButton) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemMenuButtonDao.insert(systemMenuButton);
		return count;
	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param menuId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemMenuButtonService#delete(java.
	 * lang.String)
	 */

	@Override
	public int delete(String menuId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemMenuButtonDao.delete(menuId);
		return count;
	}

	/*
	 * <p>Title: findButtonByMenuId</p> <p>Description: </p>
	 * 
	 * @param menuId
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemMenuButtonService#
	 * findButtonByMenuId(java.lang.String)
	 */

	@Override
	public Set<String> findButtonByMenuId(String menuId) {
		// TODO Auto-generated method stub
		Set<String> result = systemMenuButtonDao.findButtonByMenuId(menuId);
		return result;
	}

}
