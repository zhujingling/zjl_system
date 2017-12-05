/**
 * @Title: JedisShiroCache.java
 * @Package com.zjlsystem.shiro.redis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:31:44
 * @version V1.0
 */

package com.zjlsystem.shiro.cache;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.zjlsystem.redis.JedisManager;
import com.zjlsystem.tool.common.LoggerUtils;
import com.zjlsystem.tool.common.SerializeUtils;

/**
 * @ClassName: JedisShiroCache
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:31:44
 *
 */

public class JedisShiroCache<K, V> implements Cache<K, V>  {
	/*
	 * 为了不和其他的缓存混淆，采用追加前缀方式以作区分
	 */
	private static final String REDIS_SHIRO_CACHE = "shiro-demo-cache:";
	/*
	 * Redis 分片(分区)，也可以在配置文件中配置
	 */
	private static final int DB_INDEX = 1;

	private JedisManager jedisManager;

	private String name;

	@SuppressWarnings("rawtypes")
	static final Class<JedisShiroCache> SELF = JedisShiroCache.class;

	public JedisShiroCache(String name, JedisManager jedisManager) {
		this.name = name;
		this.jedisManager = jedisManager;
	}

	/*
	 * 自定义relm中的授权/认证的类名加上授权/认证英文名字
	 */
	public String getName() {
		if (name == null)
			return "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public V get(K key) throws CacheException {
		byte[] byteKey = SerializeUtils.serialize(buildCacheKey(key));
		byte[] byteValue = new byte[0];
		try {
			byteValue = jedisManager.getValueByKey(DB_INDEX, byteKey);
		} catch (Exception e) {
			LoggerUtils.error(SELF, "get value by cache throw exception", e);
		}
		return (V) SerializeUtils.deserialize(byteValue);
	}

	@Override
	public V put(K key, V value) throws CacheException {
		V previos = get(key);
		try {
			jedisManager.saveValueByKey(DB_INDEX, SerializeUtils.serialize(buildCacheKey(key)),
					SerializeUtils.serialize(value), -1);
		} catch (Exception e) {
			LoggerUtils.error(SELF, "put cache throw exception", e);
		}
		return previos;
	}

	@Override
	public V remove(K key) throws CacheException {
		V previos = get(key);
		try {
			jedisManager.deleteByKey(DB_INDEX, SerializeUtils.serialize(buildCacheKey(key)));
		} catch (Exception e) {
			LoggerUtils.error(SELF, "remove cache  throw exception", e);
		}
		return previos;
	}

	@Override
	public void clear() throws CacheException {
		// TODO--
	}

	@Override
	public int size() {
		if (keys() == null)
			return 0;
		return keys().size();
	}

	@Override
	public Set<K> keys() {
		// TODO
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO
		return null;
	}

	private String buildCacheKey(Object key) {
		return REDIS_SHIRO_CACHE + getName() + ":" + key;
	}
}
