/**
 * @Title: SystemUserSession.java
 * @Package com.zjlsystem.entity.shiro
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午8:51:59
 * @version V1.0
 */

package com.zjlsystem.entity.shiro;

import java.io.Serializable;

import com.zjlsystem.entity.permissions.SystemUser;

/**
  * @ClassName: SystemUserSession
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月23日 下午8:51:59
  *
  */

public class SystemUserSession extends SystemUser implements Serializable {

	private static final long serialVersionUID = 1L;

	// Session Id
	private String sessionId;
	// Session Host
	private String host;
	// Session创建时间
	private String startTime;
	// Session最后交互时间
	private String lastAccess;
	// Session timeout
	private long timeout;
	// session 是否踢出
	private boolean sessionStatus = Boolean.TRUE;

	public SystemUserSession() {
	}

	public SystemUserSession(SystemUser systemUser) {
		super(systemUser);
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public boolean isSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(boolean sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

}
