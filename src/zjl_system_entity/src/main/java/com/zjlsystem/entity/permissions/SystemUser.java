package com.zjlsystem.entity.permissions;

import java.io.Serializable;

/**
 * @ClassName: SystemUser
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public class SystemUser implements Serializable {
	private static final long serialVersionUID = 1L;
	// 0:禁止登录
	public static final Long _0 = new Long(0);
	// 1:有效
	public static final Long _1 = new Long(1);

	private String id;
	private String userAccount;
	private String userRealName;
	private String userPassword;
	private String userHeadImg;
	private String userTel;
	private String userBirthday;
	private String userLastLoginTime;
	private String createTime;
	private String modifyTime;
	private String createMan;
	// 1:有效，0:禁止登录
	private Long status;

	public SystemUser() {

	}

	public SystemUser(SystemUser u) {
		this.id = u.getId();
		this.userAccount = u.getUserAccount();
		this.userRealName = u.getUserRealName();
		this.userPassword = u.getUserPassword();
		this.userHeadImg = u.getUserHeadImg();
		this.userTel = u.getUserTel();
		this.userBirthday = u.getUserBirthday();
		this.userLastLoginTime = u.getUserLastLoginTime();
		this.createTime = u.getCreateTime();
		this.modifyTime = u.getModifyTime();
		this.createMan = u.getCreateMan();
		this.status = u.getStatus();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserHeadImg() {
		return userHeadImg;
	}

	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserLastLoginTime() {
		return userLastLoginTime;
	}

	public void setUserLastLoginTime(String userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

}
