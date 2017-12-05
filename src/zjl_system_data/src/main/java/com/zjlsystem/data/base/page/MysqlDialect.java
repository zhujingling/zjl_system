/**
 * @Title: MysqlDialect.java
 * @Package com.zjlsystem.data.base.page
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:
 * 
 * @author zhujl
 * @date 2017年7月22日 下午9:45:52
 * @version V1.0
 */

package com.zjlsystem.data.base.page;

/**
 * @ClassName: MysqlDialect
 * @Description: TODO
 * @author zhujl
 * @modify zhujl
 * @date 2017年7月22日 下午9:45:52
 *
 */

public class MysqlDialect implements Dialect {
	protected static final String SQL_END_DELIMITER = ";";

	public String getLimitSqlString(String sql, int offset, int limit) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		if (offset < 0) {
			offset = 0;
		}

		StringBuffer pagingSelect = new StringBuffer();

		pagingSelect.append(sql + " limit " + offset + "," + limit);

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

	public String getCountSqlString(String sql) {
		sql = trim(sql);
		StringBuffer sb = new StringBuffer(sql.length() + 10);
		sb.append("SELECT COUNT(1) AS " + RS_COLUMN + " FROM  ( ");
		sb.append(sql);
		sb.append(")a");
		return sb.toString();
	}

	public boolean supportsLimit() {
		return true;
	}

	private static String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			sql = sql.substring(0, sql.length() - 1 - SQL_END_DELIMITER.length());
		}
		return sql;
	}
}
