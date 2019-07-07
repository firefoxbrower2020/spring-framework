package com.kittycoder.initializingbean;

import com.kittycoder.initializingbean.po.MyInitializingBean;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-7 下午 20:35
 */
public class InitializingBeanTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/initializingbean/spring-initializingbean.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		MyInitializingBean myInitializingBean = (MyInitializingBean) factory.getBean("myInitializingBean");
		System.out.println(myInitializingBean.getName());
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		MyInitializingBean myInitializingBean = (MyInitializingBean) ctx.getBean("myInitializingBean");
		System.out.println(myInitializingBean.getName());
	}
}
