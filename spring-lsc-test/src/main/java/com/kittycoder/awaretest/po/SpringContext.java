package com.kittycoder.awaretest.po;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by shucheng on 2019-7-6 上午 8:02
 * 如何使用？
 * 方法一：在类上加@Component注解来让Spring管理SpringContext这个类，
 * 然后在spring配置文件中的component-scan中要让spring能扫描到该注解
 *
 * 方法二：
 * 在spring配置文件中使用bean标签来管理SpringContext这个类
 *
 * 这里用下方法二
 */
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	// 获取ApplicationContext
	public static ApplicationContext getContext() {
		return context;
	}

	// 根据beanId获取javaBean
	public static <T> T getBean(String name) {
		return (T) context.getBean(name);
	}

	// 根据Class获取javaBean
	public static <T> T getBean(Class<T> clazz) {
		return context.getBean(clazz);
	}

	// 根据beanId和Class获取javaBean
	public static <T> T getBean(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}
}
