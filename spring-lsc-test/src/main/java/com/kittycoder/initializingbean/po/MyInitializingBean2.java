package com.kittycoder.initializingbean.po;

/**
 * Created by shucheng on 2019-7-7 下午 20:36
 */
public class MyInitializingBean2 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOtherName() {
		System.out.println("InitializingBeanTest setOtherName...");
		this.name = "chenssy 3 号";
	}
}
