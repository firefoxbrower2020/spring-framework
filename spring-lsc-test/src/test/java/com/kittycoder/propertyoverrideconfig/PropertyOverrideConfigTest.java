package com.kittycoder.propertyoverrideconfig;

import com.kittycoder.propertyoverrideconfig.po.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-10 下午 20:15
 */
public class PropertyOverrideConfigTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/propertyoverrideconfig/spring-poc.xml");
		StudentService studentService = (StudentService) ac.getBean("studentService");
		System.out.println(studentService.getName());
	}

	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/propertyoverrideconfig/spring-poc2.xml");
		StudentService studentService = (StudentService) ac.getBean("studentService");
		System.out.println(studentService.getName());
	}
}
