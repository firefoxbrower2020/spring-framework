package com.kittycoder.beanfactorypostprocessor;

import com.kittycoder.beanfactorypostprocessor.po.BeanFactoryPostProcessor_1;
import com.kittycoder.beanfactorypostprocessor.po.BeanFactoryPostProcessor_2;
import com.kittycoder.beanfactorypostprocessor.po.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by shucheng on 2019-7-9 上午 8:40
 *
 * postProcessBeanFactory方法，工作于BeanDefinition加载完成之后，Bean实例化之前，其主要作用是对加载BeanDefinition进行修改
 * 另外，与BeanPostProcessor一样，BeanFactoryPostProcessor同样支持排序，一个容器可以同时拥有多个BeanFactoryPostProcessor，
 * 这时如果我们比较在乎它们的顺序的话，可以实现Ordered接口
 *
 * 注：在postProcessBeanFactory方法中，千万不能进行Bean的实例化工作，因为这样会导致Bean过早实例化，会产生严重后果，我们需要注意的是
 * BeanFactoryPostProcessor是与BeanDefinition打交道的，如果想与Bean打交道，请使用BeanPostProcessor
 */
public class BeanFactoryPostProcessorTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/beanfactorypostprocessor/spring-beanfactorypostprocessor.xml";

	@Test
	public void test1() {
		ClassPathResource resource = new ClassPathResource(DEPENDENCY_CHECK_CONTEXT);
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);

		BeanFactoryPostProcessor_1 beanFactoryPostProcessor_1 = new BeanFactoryPostProcessor_1();
		beanFactoryPostProcessor_1.postProcessBeanFactory(factory);

		BeanFactoryPostProcessor_2 beanFactoryPostProcessor_2 = new BeanFactoryPostProcessor_2();
		beanFactoryPostProcessor_2.postProcessBeanFactory(factory);

		StudentService studentService = (StudentService) factory.getBean("studentService");
		System.out.println("student name:" + studentService.getName() + "-- age:" + studentService.getAge());
	}

	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		System.out.println("student name:" + studentService.getName() + "-- age:" + studentService.getAge());
	}
}
