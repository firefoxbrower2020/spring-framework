package com.kittycoder.beanfactorypostprocessor.po;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * Created by shucheng on 2019-7-9 上午 8:47
 */
public class BeanFactoryPostProcessor_1 implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryPostProcessor_1 ...");

		System.out.println("容器中有BeanDefinition的个数：" + beanFactory.getBeanDefinitionCount());

		// 获取指定的BeanDefinition
		BeanDefinition bd = beanFactory.getBeanDefinition("studentService");

		MutablePropertyValues pvs = bd.getPropertyValues();

		pvs.addPropertyValue("name", "chenssy1");
		pvs.addPropertyValue("age", 15);
	}

	@Override
	public int getOrder() {
		return 1;
	}
}