/**
 * @Title: SystemUserServiceImpl.java
 * @Package com.zjlsystem.business.permissions.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月22日 下午10:16:40
 * @version V1.0
 */

package com.zjlsystem.business.permissions.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlsystem.business.base.CustomerContextHolder;
import com.zjlsystem.business.permissions.ISystemUserService;
import com.zjlsystem.data.base.BaseMybatisDao;
import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.data.dao.permissions.ISystemUserDao;
import com.zjlsystem.entity.permissions.SystemUser;

/**
 * @ClassName: SystemUserServiceImpl
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月22日 下午10:16:40
 *
 */
@Service
public class SystemUserServiceImpl extends BaseMybatisDao<ISystemUserDao> implements ISystemUserService {

	@Autowired
	ISystemUserDao systemUserDao;
	/*
	 * <p>Title: insert</p> <p>Description: </p>
	 * 
	 * @param systemUser
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemUserService#insert(com.
	 * zjlsystem.entity.permissions.SystemUser)
	 */

	@Override
	public int insert(SystemUser systemUser) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemUserDao.insert(systemUser);
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
	 * com.zjlsystem.business.permissions.ISystemUserService#delete(java.lang.
	 * String)
	 */

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		int count = systemUserDao.delete(id);
		return count;
	}

	/*
	 * <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param systemUser
	 * 
	 * @return
	 * 
	 * @see com.zjlsystem.business.permissions.ISystemUserService#update(com.
	 * zjlsystem.entity.permissions.SystemUser)
	 */

	@Override
	public int update(SystemUser systemUser) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		// TODO Auto-generated method stub
		int count = systemUserDao.update(systemUser);
		return 0;
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
	 * com.zjlsystem.business.permissions.ISystemUserService#findByPage(java.
	 * util.Map, java.lang.Integer, java.lang.Integer)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<SystemUser> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		return super.findPage(resultMap, pageNo, pageSize);

	}

	/*
	 * <p>Title: login</p> <p>Description: </p>
	 * 
	 * @param userAccount
	 * 
	 * @param passWord
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemUserService#login(java.lang.
	 * String, java.lang.String)
	 */

	@Override
	public SystemUser login(String userAccount, String passWord) {
		// TODO Auto-generated method stub
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_Master);
		Map<String,String> map=new HashMap<String,String>();
		map.put("userAccount", userAccount);
		map.put("passWord", passWord);
		SystemUser systemUser = systemUserDao.login(map);
		return systemUser;
	}

	/*
	 * <p>Title: findUserByUid</p> <p>Description: </p>
	 * 
	 * @param userId
	 * 
	 * @return
	 * 
	 * @see
	 * com.zjlsystem.business.permissions.ISystemUserService#findUserByUid(java.
	 * lang.String)
	 */

	@Override
	public SystemUser findUserByUid(String userId) {
		// TODO Auto-generated method stub
		SystemUser systemUser = systemUserDao.findUserByUid(userId);
		return systemUser;
	}

}
