/*
 * @Title: JedisManager.java
 * @Package com.bh.ssm.jedis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2016年8月24日 下午4:39:18
 * @version V1.0
 */

package com.zjlsystem.redis;

import com.zjlsystem.tool.common.LoggerUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/*
  * @ClassName: JedisManager
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2016年8月24日 下午4:39:18
  *
  */

public class JedisManager {

	private JedisPool jedisPool;
	private int expire = 60000;
	
	public Jedis getJedis() {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
		} catch (Exception e) {
			throw new JedisConnectionException(e);
		}
		return jedis;
	}

	public void returnResource(Jedis jedis) {
		if (jedis == null)
			return;
		/*
		 * @deprecated starting from Jedis 3.0 this method will not be exposed.
		 *             Resource cleanup should be done using @see
		 *             {@link redis.clients.jedis.Jedis#close()} if (isBroken){
		 *             getJedisPool().returnBrokenResource(jedis); }else{
		 *             getJedisPool().returnResource(jedis); }
		 */
		jedis.close();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/*
	 * 设置过期时间
	 * 
	 * @author ruan 2013-4-11
	 * 
	 * @param key
	 * 
	 * @param seconds
	 */
	public void expire(String key, int seconds) {
		if (seconds <= 0) {
			return;
		}
		Jedis jedis = getJedis();
		jedis.expire(key, seconds);
		returnResource(jedis);
	}

	/*
	 * 设置默认过期时间
	 * 
	 * @author ruan 2013-4-11
	 * 
	 * @param key
	 */
	public void expire(String key) {
		expire(key, expire);
	}

	public byte[] getValueByKey(int dbIndex, byte[] key) throws Exception {
		Jedis jedis = null;
		byte[] result = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			result = jedis.get(key);
		} catch (Exception e) {
			isBroken = true;
			throw e;
		} finally {
			returnResource(jedis);
		}
		return result;
	}

	public void deleteByKey(int dbIndex, byte[] key) throws Exception {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			Long result = jedis.del(key);
			LoggerUtils.fmtDebug(getClass(), "删除Session结果：%s", result);
		} catch (Exception e) {
			isBroken = true;
			throw e;
		} finally {
			returnResource(jedis);
		}
	}

	public void saveValueByKey(int dbIndex, byte[] key, byte[] value, int expireTime) throws Exception {
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = getJedis();
			jedis.select(dbIndex);
			jedis.set(key, value);
			if (expireTime > 0)
				jedis.expire(key, expireTime);
		} catch (Exception e) {
			isBroken = true;
			throw e;
		} finally {
			returnResource(jedis);
		}
	}

}
