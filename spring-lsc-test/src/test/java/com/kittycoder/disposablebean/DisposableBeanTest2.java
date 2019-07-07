package com.kittycoder.disposablebean;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-7 下午 22:04
 */
public class DisposableBeanTest2 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/disposablebean/spring-disposablebean2.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		System.out.println(factory.getBean("myDisposableBean2"));
		factory.destroySingletons();
		System.out.println(factory.getBean("myDisposableBean2"));
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		System.out.println(ctx.getBean("myDisposableBean2"));
		((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
		// 由于registerShutdownHook是多线程处理，后面不等registerShutdownHook执行就已经执行完了
		System.out.println(ctx.getBean("myDisposableBean2"));
	}
}
