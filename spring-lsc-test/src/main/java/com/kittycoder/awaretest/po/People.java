package com.kittycoder.awaretest.po;

/**
 * Created by shucheng on 2019-7-6 上午 8:11
 */
public class People {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "People{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
