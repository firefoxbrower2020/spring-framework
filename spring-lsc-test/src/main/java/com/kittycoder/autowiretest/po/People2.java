package com.kittycoder.autowiretest.po;

import javax.annotation.Resource;

public class People2 {

	@Resource
	private Teacher teacher;

	public People2() {
	}

	public People2(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}