package org.springframework.context.frameworktest.qualifiertest.common;

/**
 * Created by shucheng on 2019-6-15 下午 20:16
 */
public class MysqlDriverManagerDataSource implements DataSource {
	@Override
	public void connection() {
		System.out.println("mysql database connecting...");
	}
}
