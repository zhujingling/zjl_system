/**
 * @Title: JedisShiroCacheManager.java
 * @Package com.zjlsystem.shiro.redis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:36:27
 * @version V1.0
 */

package com.zjlsystem.shiro.cache;

import org.apache.shiro.cache.Cache;

import com.zjlsystem.redis.JedisManager;

/**
  * @ClassName: JedisShiroCacheManager
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月23日 下午8:36:27
  *
  */

public class JedisShiroCacheManager implements IShiroCacheManager {

	private JedisManager jedisManager;

	@Override
	public <K, V> Cache<K, V> getCache(String name) {
		return new JedisShiroCache<K, V>(name, getJedisManager());
	}

	@Override
	public void destroy() {
		// 如果和其他系统，或者应用在一起就不能关闭
		// getJedisManager().getJedis().shutdown();
	}

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}

}
