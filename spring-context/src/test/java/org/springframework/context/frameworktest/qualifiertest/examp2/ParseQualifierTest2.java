package org.springframework.context.frameworktest.qualifiertest.examp2;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;
import org.springframework.context.frameworktest.qualifiertest.common.MysqlDriverManagerDataSource;
import org.springframework.context.frameworktest.qualifiertest.common.OracleDriverManagerDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-15 下午 20:23
 * 缺省的根据Bean名字注入：最基本方式，是在Bean上没有指定<qualifier>标签时一种容错机制，
 * 即缺省情况下使用Bean标识符注入，但如果你指定了<qualifier>标签将不会发生容错
 */
public class ParseQualifierTest2 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "org/springframework/context/frameworktest/qualifiertest/parseQualifierTest2.xml";
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
	}

	@Test
	public void autowiredTest() {

		TestBean bean = ctx.getBean("testBean", TestBean.class);
		DataSource dataSource = bean.getDataSource();
		if (dataSource instanceof MysqlDriverManagerDataSource) {
			System.out.println("mysql");
		} else if (dataSource instanceof OracleDriverManagerDataSource) {
			System.out.println("oracle");
		}
		dataSource.connection();
	}
}
