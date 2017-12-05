/**
 * @Title: CustomShiroCacheManager.java
 * @Package com.zjlsystem.shiro.redis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午11:20:55
 * @version V1.0
 */

package com.zjlsystem.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

/**
 * @ClassName: CustomShiroCacheManager
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午11:20:55
 *
 */

public class CustomShiroCacheManager implements CacheManager, Destroyable {

	private IShiroCacheManager shiroCacheManager;

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return getShiroCacheManager().getCache(name);
	}

	@Override
	public void destroy() throws Exception {
		shiroCacheManager.destroy();
	}

	public IShiroCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(IShiroCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}
}
