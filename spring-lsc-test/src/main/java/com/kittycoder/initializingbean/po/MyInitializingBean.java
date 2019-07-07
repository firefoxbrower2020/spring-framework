package com.kittycoder.initializingbean.po;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by shucheng on 2019-7-7 下午 20:36
 */
public class MyInitializingBean implements InitializingBean {

	private String name;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBeanTest initializing...");
		this.name = "chenssy 2 号";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
