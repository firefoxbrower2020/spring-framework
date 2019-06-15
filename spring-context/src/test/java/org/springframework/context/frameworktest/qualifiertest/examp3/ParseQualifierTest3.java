package org.springframework.context.frameworktest.qualifiertest.examp3;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;
import org.springframework.context.frameworktest.qualifiertest.common.MysqlDriverManagerDataSource;
import org.springframework.context.frameworktest.qualifiertest.common.OracleDriverManagerDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-15 下午 20:23
 * 扩展@Qualifier限定描述符注解(不带参数)：对@Qualifier的扩展来提供细粒度选择候选者
 */
public class ParseQualifierTest3 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "org/springframework/context/frameworktest/qualifiertest/parseQualifierTest3.xml";
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
	}

	@Test
	public void autowiredTest() {

		TestBean bean = ctx.getBean("testBean", TestBean.class);
		DataSource dataSource = bean.getMysqlDataSource();
		if (dataSource instanceof MysqlDriverManagerDataSource) {
			System.out.println("mysql");
		} else if (dataSource instanceof OracleDriverManagerDataSource) {
			System.out.println("oracle");
		}
		dataSource.connection();
	}
}
