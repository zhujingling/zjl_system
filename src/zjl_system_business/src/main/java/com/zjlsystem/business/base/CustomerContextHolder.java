/**
 * @Title: CustomerContextHolder.java
 * @Package com.zjlsystem.business.base
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:50:31
 * @version V1.0
 */

package com.zjlsystem.business.base;

import org.springframework.util.StringUtils;

/**
  * @ClassName: CustomerContextHolder
  * @Description: TODO
  * @author zhujl
  * @modify zhujl
  * @date 2017年7月19日 下午8:50:31
  *
  */

public class CustomerContextHolder {
	public static final String DATA_SOURCE_Master = "dataSourceMaster";
	public static final String DATA_SOURCE_Slave = "dataSourceSlave";
	// 用ThreadLocal来设置当前线程使用哪个dataSource
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		String dataSource = contextHolder.get();
		if (StringUtils.isEmpty(dataSource)) {
			return DATA_SOURCE_Master;
		} else {
			return dataSource;
		}
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
