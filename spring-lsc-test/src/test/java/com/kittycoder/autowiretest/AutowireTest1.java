package com.kittycoder.autowiretest;

import com.kittycoder.autowiretest.po.People1;
import com.kittycoder.autowiretest.po.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-3 上午 8:21
 * 根据type注入
 */
public class AutowireTest1 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/autowiretest/spring-autowiretest1.xml";
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
	}

	@Test
	public void test() {
		People1 people1 = (People1) ctx.getBean("people1");
		Teacher t = people1.getTeacher();
		t.work();
	}
}
