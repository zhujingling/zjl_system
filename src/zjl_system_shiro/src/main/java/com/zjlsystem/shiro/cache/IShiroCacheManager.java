/**
 * @Title: IShiroCacheManager.java
 * @Package com.zjlsystem.shiro.redis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:30:10
 * @version V1.0
 */

package com.zjlsystem.shiro.cache;

import org.apache.shiro.cache.Cache;

/**
 * @ClassName: IShiroCacheManager
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:30:10
 *
 */

public interface IShiroCacheManager {
	<K, V> Cache<K, V> getCache(String name);

	void destroy();

}
