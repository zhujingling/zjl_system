/**
 * @Title: ConfigUtils.java
 * @Package com.zjlsystem.tool.common
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月21日 下午9:27:24
 * @version V1.0
 */

package com.zjlsystem.tool.common;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: ConfigUtils
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月21日 下午9:27:24
 *
 */

public class ConfigUtils {
	/**
	 * 同步锁
	 */
	private static final Object obj = new Object();

	/**
	 * 配置文件
	 */
	private static Properties prop = null;

	/**
	 * 配置对象单例模式
	 */
	private static ConfigUtils config = null;

	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/config.properties";

	static {
		prop = new Properties();
		try {
			prop.load(ConfigUtils.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.fmtError(ConfigUtils.class, e, "加载文件异常，文件路径：%s", FILE_NAME);
		}

	}

	/**
	 * 获取单例模式对象实例
	 * 
	 * @return 唯一对象实例
	 */
	public static ConfigUtils getInstance() {
		if (null == config) {
			synchronized (obj) {
				config = new ConfigUtils();
			}
		}
		return config;
	}

	/**
	 */
	public static String get(String key) {
		return prop.getProperty(key);
	}

}
