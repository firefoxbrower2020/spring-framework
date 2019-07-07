package com.kittycoder.initializingbean;

import com.kittycoder.initializingbean.po.MyInitializingBean2;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-7 下午 20:35
 */
public class InitializingBeanTest2 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/initializingbean/spring-initializingbean2.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		MyInitializingBean2 myInitializingBean2 = (MyInitializingBean2) factory.getBean("myInitializingBean2");
		System.out.println(myInitializingBean2.getName());
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		MyInitializingBean2 myInitializingBean2 = (MyInitializingBean2) ctx.getBean("myInitializingBean2");
		System.out.println(myInitializingBean2.getName());
	}
}
