package com.kittycoder.customtypeconverter;

import com.kittycoder.customtypeconverter.po.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-13 下午 23:43
 */
public class CustomTypeConverterTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/customtypeconverter/spring-customtypeconverter.xml");
		Student student = (Student) ac.getBean("student");
		System.out.println(student);
	}
}
