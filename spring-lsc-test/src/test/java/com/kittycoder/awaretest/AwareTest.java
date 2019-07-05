package com.kittycoder.awaretest;

import com.kittycoder.awaretest.po.MyApplicationAware;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-5 下午 20:48
 * 测试Aware
 */
public class AwareTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/awaretest/spring-aware.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		MyApplicationAware myApplicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
		myApplicationAware.display1();
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		MyApplicationAware myApplicationAware = (MyApplicationAware) ctx.getBean("myApplicationAware");
		myApplicationAware.display2();
	}
}
