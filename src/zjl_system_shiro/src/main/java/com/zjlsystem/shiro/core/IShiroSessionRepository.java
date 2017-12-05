/*
 * @Title: ShiroSessionRepository.java
 * @Package com.bh.ssm.core.shiro.session
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2016年8月22日 上午10:20:17
 * @version V1.0
 */

package com.zjlsystem.shiro.core;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * @ClassName: IShiroCacheManager
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:35:12
 *
 */

public interface IShiroSessionRepository {

	/*
	 * 存储Session
	 * 
	 * @param session
	 */
	void saveSession(Session session);

	/*
	 * 删除session
	 * 
	 * @param sessionId
	 */
	void deleteSession(Serializable sessionId);

	/*
	 * 获取session
	 * 
	 * @param sessionId
	 * 
	 * @return
	 */
	Session getSession(Serializable sessionId);

	/*
	 * 获取所有sessoin
	 * 
	 * @return
	 */
	Collection<Session> getAllSessions();
}
