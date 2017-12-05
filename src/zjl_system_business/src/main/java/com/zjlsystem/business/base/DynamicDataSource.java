/**
 * @Title: DynamicDataSource.java
 * @Package com.zjlsystem.business.base
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月19日 下午8:50:55
 * @version V1.0
 */

package com.zjlsystem.business.base;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: DynamicDataSource
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月19日 下午8:50:55
 *
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/*
	 * <p>Title: determineCurrentLookupKey</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see
	 * org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	 * determineCurrentLookupKey()
	 */

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return CustomerContextHolder.getCustomerType();
	}
}
