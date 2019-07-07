package com.kittycoder.disposablebean.po;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by shucheng on 2019-7-7 下午 22:02
 */
public class MyDisposableBean implements DisposableBean {

	private String name;

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBeanTest initializing...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyDisposableBean{" +
				"name='" + name + '\'' +
				'}';
	}
}
