package org.springframework.context.frameworktest.qualifiertest.common;

/**
 * Created by shucheng on 2019-6-15 下午 20:17
 */
public class OracleDriverManagerDataSource implements DataSource {
	@Override
	public void connection() {
		System.out.println("oracle database connecting...");
	}
}
