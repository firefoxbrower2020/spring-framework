package com.kittycoder.propertyplaceholderconfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-10 下午 18:07
 * PropertyPlaceholderConfigurer的应用（只要在VM options中添加参数即可，如：-Dspring.profiles.active=test）
 * http://www.bejson.com/a/11.html
 */
public class PropertyPlaceholderConfigTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/propertyplaceholderconfig/spring-pphc.xml");
		StudentService studentService = (StudentService) ac.getBean("studentService");
		System.out.println(studentService.getName());
	}
}
