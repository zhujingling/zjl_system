/**
 * @Title: SystemMenuServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月26日 下午7:43:52
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemMenuService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.data.dao.permissions.ISystemMenuDao;
import com.zjlsystem.entity.permissions.SystemMenu;

/**
 * @ClassName: SystemMenuServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月26日 下午7:43:52
 *
 */
@Service
public class SystemMenuServiceImpl extends BaseMybatisDao<ISystemMenuDao> implements ISystemMenuService {

	@Autowired
	ISystemMenuDao systemMenuDao;
	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemMenu
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemMenuService#insert(com.
	 * zjlsystem.entity.permissions.SystemMenu)
	 */

	@Override
	public int insert(SystemMenu systemMenu) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemMenuDao.insert(systemMenu);
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
	 * com.zjlsystem.business.permissions.ISystemMenuService#delete(java.lang.
	 * String)
	 */

	@Override
	public int delete(String menuId) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemMenuDao.delete(menuId);
		return count;
	}

	/*
	 * <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param systemMenu
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemMenuService#update(com.
	 * zjlsystem.entity.permissions.SystemMenu)
	 */

	@Override
	public int update(SystemMenu systemMenu) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemMenuDao.update(systemMenu);
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
	 * com.zjlsystem.business.permissions.ISystemMenuService#findByPage(java.
	 * util.Map, java.lang.Integer, java.lang.Integer)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SystemMenu> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return super.findPage(resultMap, pageNo, pageSize);
	}

	/*
	 * <p>Title: findMenuByMenuId</p> <p>Description: </p>
	 * 
	 * @param menuId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemMenuService#findMenuByMenuId(
	 * java.lang.String)
	 */

	@Override
	public SystemMenu findMenuByMenuId(String menuId) {
		// TODO Auto-generated method stub
		SystemMenu result = systemMenuDao.findMenuByMenuId(menuId);
		return result;
	}

	/*
	 * <p>Title: findAllMenu</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemMenuService#findAllMenu()
	 */

	@Override
	public List<SystemMenu> findAllMenu() {
		// TODO Auto-generated method stub
		return systemMenuDao.findAllMenu();
	}

}
