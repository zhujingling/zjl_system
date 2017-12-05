/**
 * @Title: Paginable.java
 * @Package com.zjlsystem.data.base.page
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月22日 下午9:49:18
 * @version V1.0
 */

package com.zjlsystem.data.base.page;

/**
 * @ClassName: Paginable
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月22日 下午9:49:18
 *
 */

public interface Paginable {
	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public int getTotalCount();

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getTotalPage();

	/**
	 * 每页记录数
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * 当前页号
	 * 
	 * @return
	 */
	public int getPageNo();

	/**
	 * 是否第一页
	 *
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * 是否最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 返回下页的页号
	 */
	public int getNextPage();

	/**
	 * 返回上页的页号
	 */
	public int getPrePage();
}
