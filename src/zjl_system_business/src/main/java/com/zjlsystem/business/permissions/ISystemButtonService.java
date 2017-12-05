/**
 * @Title: ISystemButtonService.java
 * @Package com.zjlsystem.business.permissions
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:14:57
 * @version V1.0
 */

package com.zjlsystem.business.permissions;

import java.util.List;
import java.util.Map;

import com.zjlsystem.data.base.page.Pagination;
import com.zjlsystem.entity.permissions.SystemButton;

/**
 * @ClassName: ISystemButtonService
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:14:57
 *
 */

public interface ISystemButtonService {
	/* 添加数据 */
	int insert(SystemButton systemButton);

	/* 删除数据 */
	int delete(String id);

	/* 更新数据 */
	int update(SystemButton systemButton);

	Pagination<SystemButton> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);

	SystemButton findButtonByButtonId(String buttonId);
	
	List<SystemButton> getAllButton();

}
