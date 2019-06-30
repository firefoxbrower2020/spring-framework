package com.kittycoder.simpledemo;

import com.kittycoder.simpledemo.po.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-30 下午 20:41
 * 构造函数
 */
public class ConstructorTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/simpledemo/spring-constructor.xml");
		Student student = (Student) ac.getBean("student");
		System.out.println(student);
	}
}
