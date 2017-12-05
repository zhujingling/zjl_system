/**
 * @Title: CustomerSessionListener.java
 * @Package com.zjlsystem.shiro.listener
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午10:46:57
 * @version V1.0
 */

package com.zjlsystem.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.zjlsystem.shiro.core.IShiroSessionRepository;

/**
 * @ClassName: CustomerSessionListener
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午10:46:57
 *
 */

public class CustomerSessionListener implements SessionListener {

	private IShiroSessionRepository shiroSessionRepository;

	/*
	 * 一个会话的生命周期开始
	 */
	@Override
	public void onStart(Session session) {
		// TODO
		System.out.println("on start");
	}

	/*
	 * 一个会话的生命周期结束
	 */
	@Override
	public void onStop(Session session) {
		// TODO
		System.out.println("on stop");
	}

	@Override
	public void onExpiration(Session session) {
		shiroSessionRepository.deleteSession(session.getId());
	}

	public IShiroSessionRepository getShiroSessionRepository() {
		return shiroSessionRepository;
	}

	public void setShiroSessionRepository(IShiroSessionRepository shiroSessionRepository) {
		this.shiroSessionRepository = shiroSessionRepository;
	}
}
