package com.kittycoder.customtypeconverter.po;

/**
 * Created by shucheng on 2019-7-13 下午 23:37
 */
public class StudentService {

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
		return "StudentService{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
