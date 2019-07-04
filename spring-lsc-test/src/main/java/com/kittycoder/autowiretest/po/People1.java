package com.kittycoder.autowiretest.po;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shucheng on 2019-7-3 上午 8:15
 */
public class People1 {

	private Teacher teacher;

	public People1() {
	}

	@Autowired
	public People1(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
