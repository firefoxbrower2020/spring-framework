package com.kittycoder.beanpostprocessor;

import com.kittycoder.beanpostprocessor.po.MyBeanPostProcessor;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-6 下午 20:40
 * 手动加到DefaultListableBeanFactory中，这时后续要初始化的普通bean，以及BeanPostProcessor的实现类本身也被加到后置处理中了
 */
public class BeanPostProcessorTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/beanpostprocessor/spring-beanpostprocessor.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 下面这行代码用来解决MyBeanPostProcessor中两个实现方法未被执行的问题
		// 另外一种解决方法：直接让MyBeanPostProcessor实现BeanFactoryAware接口，然后在factory中把processor加进去就行了
		factory.addBeanPostProcessor(new MyBeanPostProcessor());
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor) factory.getBean("myBeanPostProcessor");
		myBeanPostProcessor.display();
	}
}
