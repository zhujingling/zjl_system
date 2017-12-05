/**
 * @Title: SystemButtonServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:19:18
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemButtonService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.data.dao.permissions.ISystemButtonDao;
import com.zjlsystem.entity.permissions.SystemButton;

/**
 * @ClassName: SystemButtonServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:19:18
 *
 */
@Service
public class SystemButtonServiceImpl extends BaseMybatisDao<ISystemButtonDao> implements ISystemButtonService {

	@Autowired
	ISystemButtonDao systemButtonDao;

	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemButton
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemButtonService#insert(com.
	 * zjlsystem.entity.permissions.SystemButton)
	 */

	@Override
	public int insert(SystemButton systemButton) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemButtonDao.insert(systemButton);
		return count;
	}

	/*
	 * <p>Title: delete</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemButtonService#delete(java.lang.
	 * String)
	 */

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemButtonDao.delete(id);
		return count;
	}

	/*
	 * <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param systemButton
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemButtonService#update(com.
	 * zjlsystem.entity.permissions.SystemButton)
	 */

	@Override
	public int update(SystemButton systemButton) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		// TODO Auto-generated method stub
		int count = systemButtonDao.update(systemButton);
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
	 * com.zjlsystem.business.permissions.ISystemButtonService#findByPage(java.
	 * util.Map, java.lang.Integer, java.lang.Integer)
	 */

	@Override
	public Pagination<SystemButton> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		return super.findPage(resultMap, pageNo, pageSize);
	}

	/*
	 * <p>Title: finaButtonByButtonId</p> <p>Description: </p>
	 * 
	 * @param buttonId
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemButtonService#
	 * finaButtonByButtonId(java.lang.String)
	 */

	@Override
	public SystemButton findButtonByButtonId(String buttonId) {
		// TODO Auto-generated method stub
		SystemButton result = systemButtonDao.findButtonByButtonId(buttonId);
		return result;
	}

	/*
	  * <p>Title: getAllButton</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.zjlsystem.business.permissions.ISystemButtonService#getAllButton()
	  */
	
	
	@Override
	public List<SystemButton> getAllButton() {
		// TODO Auto-generated method stub
		List<SystemButton> result = systemButtonDao.getAllButton();
		return result;
	}

}
