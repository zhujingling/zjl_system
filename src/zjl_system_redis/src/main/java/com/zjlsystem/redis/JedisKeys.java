/*
 * @Title: Keys.java
 * @Package com.bh.ssm.jedis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2016年8月24日 下午5:00:42
 * @version V1.0
 */

package com.zjlsystem.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.util.SafeEncoder;

/*
  * @ClassName: Keys
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2016年8月24日 下午5:00:42
  *
  */

public class JedisKeys {
	private JedisManager jedisManager = new JedisManager();

	/*
	 * 清空所有key
	 */
	public String flushAll() {
		Jedis jedis = jedisManager.getJedis();
		String stata = jedis.flushAll();
		jedisManager.returnResource(jedis);
		return stata;
	}

	/*
	 * 更改key
	 * 
	 * @param String oldkey
	 * 
	 * @param String newkey
	 * 
	 * @return 状态码
	 */
	public String rename(String oldkey, String newkey) {
		return rename(SafeEncoder.encode(oldkey), SafeEncoder.encode(newkey));
	}

	/*
	 * 更改key,仅当新key不存在时才执行
	 * 
	 * @param String
	 *            oldkey
	 * @param String
	 *            newkey
	 * @return 状态码
	 */
	public long renamenx(String oldkey, String newkey) {
		Jedis jedis = jedisManager.getJedis();
		long status = jedis.renamenx(oldkey, newkey);
		jedisManager.returnResource(jedis);
		return status;
	}

	/*
	 * 更改key
	 * 
	 * @param String
	 *            oldkey
	 * @param String
	 *            newkey
	 * @return 状态码
	 */
	public String rename(byte[] oldkey, byte[] newkey) {
		Jedis jedis = jedisManager.getJedis();
		String status = jedis.rename(oldkey, newkey);
		jedisManager.returnResource(jedis);
		return status;
	}

	/*
	 * 设置key的过期时间，以秒为单位
	 * 
	 * @param String
	 *            key
	 * @param 时间
	 *            ,已秒为单位
	 * @return 影响的记录数
	 */
	public long expired(String key, int seconds) {
		Jedis jedis = jedisManager.getJedis();
		long count = jedis.expire(key, seconds);
		jedisManager.returnResource(jedis);
		return count;
	}

	/*
	 * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
	 * 
	 * @param String
	 *            key
	 * @param 时间
	 *            ,已秒为单位
	 * @return 影响的记录数
	 */
	public long expireAt(String key, long timestamp) {
		Jedis jedis = jedisManager.getJedis();
		long count = jedis.expireAt(key, timestamp);
		jedisManager.returnResource(jedis);
		return count;
	}

	/*
	 * 查询key的过期时间
	 * 
	 * @param String
	 *            key
	 * @return 以秒为单位的时间表示
	 */
	public long ttl(String key) {
		Jedis jedis = jedisManager.getJedis();
		long len = jedis.ttl(key);
		jedisManager.returnResource(jedis);
		return len;
	}

	/*
	 * 取消对key过期时间的设置
	 * 
	 * @param key
	 * @return 影响的记录数
	 */
	public long persist(String key) {
		Jedis jedis = jedisManager.getJedis();
		long count = jedis.persist(key);
		jedisManager.returnResource(jedis);
		return count;
	}

	/*
	 * 删除keys对应的记录,可以是多个key
	 * 
	 * @param String
	 *            ... keys
	 * @return 删除的记录数
	 */
	public long del(String... keys) {
		Jedis jedis = jedisManager.getJedis();
		long count = jedis.del(keys);
		jedisManager.returnResource(jedis);
		return count;
	}

	/*
	 * 删除keys对应的记录,可以是多个key
	 * 
	 * @param String
	 *            ... keys
	 * @return 删除的记录数
	 */
	public long del(byte[]... keys) {
		Jedis jedis = jedisManager.getJedis();
		long count = jedis.del(keys);
		jedisManager.returnResource(jedis);
		return count;
	}

	/*
	 * 判断key是否存在
	 * 
	 * @param String
	 *            key
	 * @return boolean
	 */
	public boolean exists(String key) {
		Jedis jedis = jedisManager.getJedis();
		boolean exis = jedis.exists(key);
		jedisManager.returnResource(jedis);
		return exis;
	}

	/*
	 * 对List,Set,SortSet进行排序,如果集合数据较大应避免使用这个方法
	 * 
	 * @param String
	 *            key
	 * @return List<String> 集合的全部记录
	 **/
	public List<String> sort(String key) {
		Jedis jedis = jedisManager.getJedis();
		List<String> list = jedis.sort(key);
		jedisManager.returnResource(jedis);
		return list;
	}

	/*
	 * 对List,Set,SortSet进行排序或limit
	 * 
	 * @param String
	 *            key
	 * @param SortingParams
	 *            parame 定义排序类型或limit的起止位置.
	 * @return List<String> 全部或部分记录
	 **/
	public List<String> sort(String key, SortingParams parame) {
		Jedis jedis = jedisManager.getJedis();
		List<String> list = jedis.sort(key, parame);
		jedisManager.returnResource(jedis);
		return list;
	}

	/*
	 * 返回指定key存储的类型
	 * 
	 * @param String
	 *            key
	 * @return String string|list|set|zset|hash
	 **/
	public String type(String key) {
		Jedis jedis = jedisManager.getJedis();
		String type = jedis.type(key);
		jedisManager.returnResource(jedis);
		return type;
	}

	/*
	 * 查找所有匹配给定的模式的键
	 * 
	 * @param String
	 *            key的表达式,*表示多个，？表示一个
	 */
	public Set<String> keys(String pattern) {
		Jedis jedis = jedisManager.getJedis();
		Set<String> set = jedis.keys(pattern);
		jedisManager.returnResource(jedis);
		return set;
	}

}
