package com.kittycoder.simpledemo.po;

/**
 * Created by shucheng on 2019-6-30 下午 21:09
 * 实例工厂
 */
public class StudentInstanceFactory {

	public Student newInstance() {
		System.out.println("调用无参的实例工厂");
		return new Student(1, "张三");
	}

	public Student newInstance(Integer id, String name) {
		System.out.println("调用带参的实例工厂");
		return new Student(id, name);
	}
}
