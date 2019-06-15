package org.springframework.context.frameworktest.qualifiertest.examp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;

/**
 * Created by shucheng on 2019-6-15 下午 20:18
 */
public class TestBean {

	private DataSource dataSource;

	@Autowired
	public void initDataSource(@Qualifier("oracleDataSource") DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// 还可以写成
	/*@Autowired
	@Qualifier(value = "oracleDataSource")
	public void initDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

	public DataSource getDataSource() {
		return dataSource;
	}
}
