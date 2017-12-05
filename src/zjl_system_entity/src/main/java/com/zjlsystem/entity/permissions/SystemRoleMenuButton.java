package com.zjlsystem.entity.permissions;
/**
 * @ClassName: SystemRoleMenuButton
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public class SystemRoleMenuButton {
	private String id;
	private String roleId;
	private String menuId;
	private String buttonId;
	private String remarks;
	private String createTime;
	private String createMan;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

}
