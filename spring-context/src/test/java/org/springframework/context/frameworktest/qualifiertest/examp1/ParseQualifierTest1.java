package org.springframework.context.frameworktest.qualifiertest.examp1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.frameworktest.qualifiertest.common.DataSource;
import org.springframework.context.frameworktest.qualifiertest.common.MysqlDriverManagerDataSource;
import org.springframework.context.frameworktest.qualifiertest.common.OracleDriverManagerDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-15 下午 20:23
 * 根据基于XML配置中的<qualifier>标签指定的名字进行注入
 */
public class ParseQualifierTest1 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "org/springframework/context/frameworktest/qualifiertest/parseQualifierTest1.xml";
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

		try {
			ctx.getBean("mysqlDataSource");
		} catch (Exception e) {
			if (e instanceof NoSuchBeanDefinitionException) {
				System.out.println("@Qualifier不能作为Bean的标识符");
			}
			e.printStackTrace();
		}
	}
}
