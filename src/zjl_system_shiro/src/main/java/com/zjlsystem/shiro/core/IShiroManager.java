/**
 * @Title: IShiroManager.java
 * @Package com.zjlsystem.shiro.core
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午11:11:52
 * @version V1.0
 */

package com.zjlsystem.shiro.core;

/**
 * @ClassName: IShiroManager
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午11:11:52
 *
 */

public interface IShiroManager {
	/*
	 * 加载过滤配置信息
	 * 
	 * @return
	 */
	public String loadFilterChainDefinitions();

	/*
	 * 重新构建权限过滤器 一般在修改了用户角色、用户等信息时，需要再次调用该方法
	 */
	public void reCreateFilterChains();

}
