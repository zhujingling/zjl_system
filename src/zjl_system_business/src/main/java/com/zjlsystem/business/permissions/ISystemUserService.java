/**
 * @Title: ISystemUserService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:17:11
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.Map;

import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.permissions.SystemUser;

/**
 * @ClassName: ISystemUserService
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:17:11
 *
 */

public interface ISystemUserService {
	/**/
	int insert(SystemUser systemUser);

	int delete(String id);

	int update(SystemUser systemUser);

	Pagination<SystemUser> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	
	SystemUser login(String userAccount,String passWord);
	
	SystemUser findUserByUid(String userId);

}
