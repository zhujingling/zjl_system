/*
 * @Title: SessionStatus.java
 * @Package com.bh.ssm.core.shiro.session
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2016年8月22日 上午10:30:16
 * @version V1.0
 */

package com.zjlsystem.shiro.core;

import java.io.Serializable;

/**
 * @ClassName: IShiroCacheManager
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午8:35:12
 *
 */

public class SessionStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	// 是否踢出 true:有效，false：踢出。
	private Boolean onlineStatus = Boolean.TRUE;

	public Boolean isOnlineStatus() {
		return onlineStatus;
	}

	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
}
