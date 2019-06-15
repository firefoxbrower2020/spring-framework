package org.springframework.context.frameworktest.qualifiertest.examp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;

/**
 * Created by shucheng on 2019-6-15 下午 21:46
 */
public class TestBean {

	private DataSource dataSource;

	@Autowired
	@Qualifier(value = "mysqlDataSourceBean")
	public void initDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
