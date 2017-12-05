/**
 * @Title: Constant.java
 * @Package com.zjlsystem.tool.common
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月21日 下午9:22:33
 * @version V1.0
 */

package com.zjlsystem.tool.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: Constant
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月21日 下午9:22:33
 *
 */

public interface Constant {
	static final String CONTEXT_PATH = "contextPath";
	
	/*返回成功*/
	
	/*** 项目根路径 */

	/*** Freemarker 使用的变量 begin **/

	static final String TARGET = "target";// 标签使用目标

	static final String OUT_TAG_NAME = "outTagName";// 输出标签Name

	/*** Freemarker 使用的变量 end **/

	/** 其他常用变量 begin **/
	static final String NAME = "name";
	static final String ID = "id";
	static final String TOKEN = "token";
	static final String LOING_USER = "loing_user";
	/** Long */
	static final Long ZERO = new Long(0);
	static final Long ONE = new Long(1);
	static final Long TWO = new Long(2);
	static final Long THREE = new Long(3);
	static final Long EIGHT = new Long(8);

	/** String */
	static final String S_ZERO = "0";
	static final String S_ONE = "1";
	static final String S_TOW = "2";
	static final String S_THREE = "3";

	/** Integer */
	static final Integer I_ZERO = 0;
	static final Integer I_ONE = 1;
	static final Integer I_TOW = 2;
	static final Integer I_THREE = 3;
	/** 其他常用变量 end **/

	/** cache常用变量 begin **/
	static final String CACHE_NAME = "shiro_cache";
	static final String CACHE_MANAGER = "cacheManager";// cacheManager bean name
	/** cache常用变量 end **/

	/** 当前年份 **/
	static final int NOW_YEAY = Calendar.getInstance().get(Calendar.YEAR);

	/** 地址 **/
	static final String DOMAIN_WWW = ConfigUtils.get("domain.www");// 前端域名
	static final String DOMAIN_CDN = ConfigUtils.get("domain.cdn");// 后台域名
	static String VERSION = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// 版本号，重启的时间

	// 存储到缓存，标识用户的禁止状态，解决在线用户踢出的问题
	final static String EXECUTE_CHANGE_USER = "ZJL_EXECUTE_CHANGE_USER";
}
