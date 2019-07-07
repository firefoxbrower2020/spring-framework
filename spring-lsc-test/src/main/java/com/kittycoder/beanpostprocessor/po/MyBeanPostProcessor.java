package com.kittycoder.beanpostprocessor.po;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by shucheng on 2019-7-6 下午 20:40
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/* 实现BeanFactoryAware接口
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		((AbstractBeanFactory)beanFactory).addBeanPostProcessor(this);
	}*/

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] 开始初始化");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean [" + beanName + "] 完成初始化");
		return bean;
	}

	public void display() {
		System.out.println("hello BeanPostProcessor!!!");
	}
}
