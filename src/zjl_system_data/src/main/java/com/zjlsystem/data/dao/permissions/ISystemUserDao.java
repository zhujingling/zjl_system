package com.zjlsystem.data.dao.permissions;

import java.util.Map;

import com.zjlsystem.entity.permissions.SystemUser;

/**
 * @ClassName: ISystemUserDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemUserDao {
	/**/
	int insert(SystemUser systemUser);

	int delete(String id);

	int update(SystemUser systemUser);

	SystemUser login(Map<String,String> map);
	
	SystemUser findUserByUid(String userId);

}
