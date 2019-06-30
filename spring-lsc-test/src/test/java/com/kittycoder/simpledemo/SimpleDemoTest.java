package com.kittycoder.simpledemo;

import com.kittycoder.simpledemo.po.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-29 下午 20:42
 */
public class SimpleDemoTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/simpledemo/spring-student.xml");
		Teacher teacher = (Teacher) ac.getBean("teacher");
		System.out.println(teacher);
	}
}
