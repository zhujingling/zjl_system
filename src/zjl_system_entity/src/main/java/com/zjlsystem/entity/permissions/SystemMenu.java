package com.zjlsystem.entity.permissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: SystemButton
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月11日 下午8:56:54
 *
 */
public class SystemMenu implements Comparable {
	private String id;
	private String menuName;
	private String menuUrl;
	private String parentId;
	private String icon;
	private Integer orderNo;
	private Integer levels;
	private String remarks;
	private String createTime;
	private String modifyTime;
	private String createMan;

	/**
	 * 子节点的集合
	 */
	private List<SystemMenu> children;

	/**
	 * 查询子节点时候的临时集合
	 */
	private List<SystemMenu> linkedList = new ArrayList<SystemMenu>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
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

	public List<SystemMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SystemMenu> children) {
		this.children = children;
	}

	/**
	 * 构建整个菜单树
	 *
	 * @author fengshuonan
	 */
	public void buildNodeTree(List<SystemMenu> nodeList) {
		for (SystemMenu treeNode : nodeList) {
			List<SystemMenu> linkedList = treeNode.findChildNodes(nodeList, treeNode.getId());
			if (linkedList.size() > 0) {
				treeNode.setChildren(linkedList);
			}
		}
	}

	/**
	 * 查询子节点的集合
	 *
	 * @author fengshuonan
	 */
	public List<SystemMenu> findChildNodes(List<SystemMenu> nodeList, String parentId) {
		if (nodeList == null && parentId == null)
			return null;
		for (Iterator<SystemMenu> iterator = nodeList.iterator(); iterator.hasNext();) {
			SystemMenu node = (SystemMenu) iterator.next();
			// 根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (node.getParentId() != "0" && parentId.equals(node.getParentId())) {
				recursionFn(nodeList, node, parentId);
			}
		}
		return linkedList;
	}

	/**
	 * 遍历一个节点的子节点
	 *
	 * @author fengshuonan
	 */
	public void recursionFn(List<SystemMenu> nodeList, SystemMenu node, String pId) {
		List<SystemMenu> childList = getChildList(nodeList, node);// 得到子节点列表
		if (childList.size() > 0) {// 判断是否有子节点
			if (node.getParentId().equals(pId)) {
				linkedList.add(node);
			}
			Iterator<SystemMenu> it = childList.iterator();
			while (it.hasNext()) {
				SystemMenu n = (SystemMenu) it.next();
				recursionFn(nodeList, n, pId);
			}
		} else {
			if (node.getParentId().equals(pId)) {
				linkedList.add(node);
			}
		}
	}

	/**
	 * 得到子节点列表
	 *
	 * @author fengshuonan
	 */
	private List<SystemMenu> getChildList(List<SystemMenu> list, SystemMenu node) {
		List<SystemMenu> nodeList = new ArrayList<SystemMenu>();
		Iterator<SystemMenu> it = list.iterator();
		while (it.hasNext()) {
			SystemMenu n = (SystemMenu) it.next();
			if (n.getParentId().equals(node.getId())) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	/**
	 * 清除所有二级菜单
	 *
	 * @date 2017年2月19日 下午11:18:19
	 */
	public static List<SystemMenu> clearLevelTwo(List<SystemMenu> nodes) {
		ArrayList<SystemMenu> results = new ArrayList<SystemMenu>();
		for (SystemMenu node : nodes) {
			Integer levels = node.getLevels();
			if (levels.equals(1)) {
				results.add(node);
			}
		}
		return results;
	}

	/**
	 * 构建菜单列表
	 *
	 * @date 2017年2月19日 下午11:18:19
	 */
	public static List<SystemMenu> buildTitle(List<SystemMenu> nodes) {

		new SystemMenu().buildNodeTree(nodes);

		List<SystemMenu> menuNodes = clearLevelTwo(nodes);

		// 对菜单排序
		Collections.sort(menuNodes);

		// 对菜单的子菜单进行排序
		for (SystemMenu menuNode : menuNodes) {
			if (menuNode.getChildren() != null && menuNode.getChildren().size() > 0) {
				Collections.sort(menuNode.getChildren());
			}
		}

		return menuNodes;
	}

	/*
	 * <p>Title: compareTo</p> <p>Description: </p>
	 * 
	 * @param o
	 * 
	 * @return
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		SystemMenu menuNode = (SystemMenu) o;
		Integer orderNo = menuNode.getOrderNo();
		if (orderNo == null) {
			orderNo = 0;
		}
		return this.orderNo.compareTo(orderNo);
	}

}
