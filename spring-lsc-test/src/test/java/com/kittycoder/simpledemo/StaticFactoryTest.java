package com.kittycoder.simpledemo;

import com.kittycoder.simpledemo.po.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-30 下午 21:12
 * 静态工厂方法
 */
public class StaticFactoryTest {

	private ApplicationContext ac;

	@Before
	public void setUp() {
		ac = new ClassPathXmlApplicationContext("com/kittycoder/simpledemo/spring-staticfactory.xml");
	}

	@Test
	public void staticFactoryTest() {
		Student student1 = (Student) ac.getBean("student1");
		System.out.println(student1);
	}

	@Test
	public void staticFactoryWithParamTest() {
		Student student2 = (Student) ac.getBean("student2");
		System.out.println(student2);
	}
}
