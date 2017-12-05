/**
 * @Title: SampleRealm.java
 * @Package com.zjlsystem.shiro.token
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月23日 下午9:17:46
 * @version V1.0
 */

package com.zjlsystem.shiro.token;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjlsystem.business.permissions.ISystemRoleMenuService;
import com.zjlsystem.business.permissions.ISystemUserRoleService;
import com.zjlsystem.business.permissions.ISystemUserService;
import com.zjlsystem.entity.permissions.SystemUser;

/**
  * @ClassName: SampleRealm
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月23日 下午9:17:46
  *
  */

public class SampleRealm extends AuthorizingRealm {

	@Autowired
	ISystemRoleMenuService roleMenuService;
	@Autowired
	ISystemUserRoleService userRoleService;
	@Autowired
	ISystemUserService userService;	


	public SampleRealm() {
		super();
	}
	/*
	 * 
	 * 认证信息，主要针对用户登录，
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {

		ShiroToken token = (ShiroToken) authcToken;

		SystemUser user = userService.login(token.getUsername(), token.getPswd());
		if (user != null) {
			if (SystemUser._0.equals(user.getStatus())) {
				throw new DisabledAccountException("帐号已经禁止登录！");
			} else { // 更新登录时间 last login time
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				user.setUserLastLoginTime(df.format(new Date()));
				userService.update(user);
			}
			return new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
		} else {
			throw new AccountException("帐号或密码不正确！");
		}

	}

	/*
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		String userId = TokenManager.getUserId();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户ID查询角色（role），放入到Authorization里。
		Set<String> roles = userRoleService.findRoleByUserId(userId);
		info.setRoles(roles);
		// 根据用户ID查询权限（permission），放入到Authorization里。
		Set<String> permissions=new HashSet<String>();
		for (String rId : roles) {
			Set<String> item=roleMenuService.findMenuByRoleId(rId);
			if(item.size()>0){
				permissions.addAll(item);
			}
		}
		info.setStringPermissions(permissions);
		return info;
	}

	/*
	 * 清空当前用户权限信息
	 */
	public void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

	/*
	 * 指定principalCollection 清楚
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
