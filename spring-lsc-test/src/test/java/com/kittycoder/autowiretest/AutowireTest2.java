package com.kittycoder.autowiretest;

import com.kittycoder.autowiretest.po.People2;
import com.kittycoder.autowiretest.po.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-3 上午 8:21
 * 根据beanId注入
 */
public class AutowireTest2 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/autowiretest/spring-autowiretest2.xml";
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
	}

	@Test
	public void test() {
		People2 people2 = (People2) ctx.getBean("people2");
		Teacher t = people2.getTeacher();
		t.work();
	}
}
