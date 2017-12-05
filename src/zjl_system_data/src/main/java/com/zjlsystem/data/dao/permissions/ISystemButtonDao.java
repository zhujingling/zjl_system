package com.zjlsystem.data.dao.permissions;


import java.util.List;

import com.zjlsystem.entity.permissions.SystemButton;
/**
 * @ClassName: ISystemButtonDao
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public interface ISystemButtonDao {
	/*添加数据*/
	int insert(SystemButton systemButton);
	/*删除数据*/
	int delete(String id);
	/*更新数据*/
	int update(SystemButton systemButton);
	
	SystemButton findButtonByButtonId(String buttonId);
	
	List<SystemButton> getAllButton();
}
