package com.kittycoder.lifecycle;

import com.kittycoder.lifecycle.po.LifeCycleBean;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-8 上午 8:20
 */
public class LifeCycleBeanTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/lifecycle/spring-lifecycle.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// BeanFactory容器一定要调用该方法进行BeanPostProcessorzhuce
		factory.addBeanPostProcessor(new LifeCycleBean()); // <1>
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		LifeCycleBean lifeCycleBean = (LifeCycleBean) factory.getBean("lifeCycle");
		lifeCycleBean.display();

		System.out.println("方法调用完成，容器开始关闭...");
		// 关闭容器
		factory.destroySingletons();
	}
}
