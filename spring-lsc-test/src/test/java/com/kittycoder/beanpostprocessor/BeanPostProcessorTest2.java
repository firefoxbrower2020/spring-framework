package com.kittycoder.beanpostprocessor;

import com.kittycoder.beanpostprocessor.po.MyBeanPostProcessor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-6 下午 20:40
 * 使用ApplicationContext，这时只有后续要初始化的普通bean被应用了后置处理，
 * BeanPostProcessor的实现类本身没有被加到后置处理中
 */
public class BeanPostProcessorTest2 {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/beanpostprocessor/spring-beanpostprocessor2.xml";

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor) ctx.getBean("myBeanPostProcessor");
		myBeanPostProcessor.display();
	}
}
