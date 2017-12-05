/**
 * @Title: ShiroToken.java
 * @Package com.zjlsystem.shiro.token
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午9:17:27
 * @version V1.0
 */

package com.zjlsystem.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName: ShiroToken
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月23日 下午9:17:27
 *
 */

public class ShiroToken extends UsernamePasswordToken implements java.io.Serializable {

	private static final long serialVersionUID = -6451794657814516274L;

	public ShiroToken(String username, String pswd) {
		super(username, pswd);
		this.pswd = pswd;
	}

	// 登录密码[字符串类型] 因为父类是char[] ]
	private String pswd;

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}
