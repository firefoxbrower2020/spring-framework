package com.kittycoder.disposablebean.po;

import org.springframework.beans.factory.DisposableBean;

/**
 * Created by shucheng on 2019-7-7 下午 22:02
 */
public class MyDisposableBean2 {

	private String name;

	public void myDestroy() {
		System.out.println("DisposableBeanTest myDestroy...");
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
