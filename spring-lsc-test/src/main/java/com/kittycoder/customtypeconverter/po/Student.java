package com.kittycoder.customtypeconverter.po;

/**
 * Created by shucheng on 2019-7-13 下午 23:36
 */
public class Student {

	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentService=" + studentService +
				'}';
	}
}
