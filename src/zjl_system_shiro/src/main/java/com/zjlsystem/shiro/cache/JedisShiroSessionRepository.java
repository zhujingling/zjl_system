/**
 * @Title: JedisShiroSessionRepository.java
 * @Package com.zjlsystem.shiro.redis
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:37:12
 * @version V1.0
 */

package com.zjlsystem.shiro.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;

import com.zjlsystem.redis.JedisManager;
import com.zjlsystem.shiro.core.CustomSessionManager;
import com.zjlsystem.shiro.core.IShiroSessionRepository;
import com.zjlsystem.shiro.core.SessionStatus;
import com.zjlsystem.tool.common.LoggerUtils;
import com.zjlsystem.tool.common.SerializeUtils;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: JedisShiroSessionRepository
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:37:12
 *
 */

public class JedisShiroSessionRepository implements IShiroSessionRepository {
	public static final String REDIS_SHIRO_SESSION = "sojson-shiro-demo-session:";
	// 这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
	public static final String REDIS_SHIRO_ALL = "*sojson-shiro-demo-session:*";
	private static final int SESSION_VAL_TIME_SPAN = 18000;
	private static final int DB_INDEX = 1;

	private JedisManager jedisManager;

	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}

	@Override
	public void saveSession(Session session) {
		if (session == null || session.getId() == null)
			throw new NullPointerException("session is empty");
		try {
			byte[] key = SerializeUtils.serialize(buildRedisSessionKey(session.getId()));

			// 不存在才添加。
			if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
				// Session 踢出自存存储。
				SessionStatus sessionStatus = new SessionStatus();
				session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
			}

			byte[] value = SerializeUtils.serialize(session);
			long sessionTimeOut = session.getTimeout() / 1000;
			Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
			getJedisManager().saveValueByKey(DB_INDEX, key, value, expireTime.intValue());
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "save session error，id:[%s]", session.getId());
		}
	}

	@Override
	public void deleteSession(Serializable id) {
		if (id == null) {
			throw new NullPointerException("session id is empty");
		}
		try {
			getJedisManager().deleteByKey(DB_INDEX, SerializeUtils.serialize(buildRedisSessionKey(id)));
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "删除session出现异常，id:[%s]", id);
		}
	}

	@Override
	public Session getSession(Serializable id) {
		if (id == null)
			throw new NullPointerException("session id is empty");
		Session session = null;
		try {
			byte[] value = getJedisManager().getValueByKey(DB_INDEX,
					SerializeUtils.serialize(buildRedisSessionKey(id)));
			session = SerializeUtils.deserialize(value, Session.class);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "获取session异常，id:[%s]", id);
		}
		return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		Collection<Session> sessions = null;
		try {
			sessions = AllSession(DB_INDEX, REDIS_SHIRO_SESSION);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "获取全部session异常");
		}

		return sessions;
	}

	private String buildRedisSessionKey(Serializable sessionId) {
		return REDIS_SHIRO_SESSION + sessionId;
	}

	/*
	 * 获取所有Session
	 * 
	 * @param dbIndex
	 * 
	 * @param redisShiroSession
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Collection<Session> AllSession(int dbIndex, String redisShiroSession) throws Exception {
		Jedis jedis = null;
		boolean isBroken = false;
		Set<Session> sessions = new HashSet<Session>();
		try {
			jedis = getJedisManager().getJedis();
			jedis.select(dbIndex);

			Set<byte[]> byteKeys = jedis.keys((JedisShiroSessionRepository.REDIS_SHIRO_ALL).getBytes());
			if (byteKeys != null && byteKeys.size() > 0) {
				for (byte[] bs : byteKeys) {
					Session obj = SerializeUtils.deserialize(jedis.get(bs), Session.class);
					if (obj instanceof Session) {
						sessions.add(obj);
					}
				}
			}
		} catch (Exception e) {
			isBroken = true;
			throw e;
		} finally {
			getJedisManager().returnResource(jedis);
		}
		return sessions;
	}

}
