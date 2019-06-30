package com.kittycoder.simpledemo.po;

/**
 * Created by shucheng on 2019-6-30 下午 21:09
 * 静态工厂
 */
public class StudentStaticFactory {

	public static Student newInstance() {
		System.out.println("调用无参的静态工厂");
		return new Student(1, "张三");
	}

	public static Student newInstance(Integer id, String name) {
		System.out.println("调用带参的静态工厂");
		return new Student(id, name);
	}
}
