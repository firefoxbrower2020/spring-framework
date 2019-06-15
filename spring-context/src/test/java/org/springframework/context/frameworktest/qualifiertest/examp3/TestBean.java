package org.springframework.context.frameworktest.qualifiertest.examp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;

/**
 * Created by shucheng on 2019-6-15 下午 22:03
 */
public class TestBean {

	private DataSource mysqlDataSource;

	private DataSource oracleDataSource;

	@Autowired
	public void initDataSource(@Mysql DataSource mysqlDataSource, @Oracle DataSource oracleDataSource) {
		this.mysqlDataSource = mysqlDataSource;
		this.oracleDataSource = oracleDataSource;
	}

	public DataSource getMysqlDataSource() {
		return mysqlDataSource;
	}

	public DataSource getOracleDataSource() {
		return oracleDataSource;
	}
}
