package org.springframework.context.frameworktest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-12 下午 22:55
 * 测试bean标签里constructor-arg标签
 */
public class ParseConstructorArgTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "parseConstructorArg.xml";
	private ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT, getClass());
	}

	@Test
	public void test1() {
		StudentService studentService = (StudentService) ctx.getBean("studentService");
		System.out.println(studentService);
	}

	@Test
	public void test2() {
		// 测试自动注入
		// https://github.com/HelloKittycoder/JavaWebLearning/tree/master/FrameworkPre/spring-study/spring14
		People people = (People) ctx.getBean("people");
		System.out.println(people);
	}
}

class StudentService {

	private String name;
	private Integer age;
	private BookService bookService;

	public StudentService(String name, Integer age, BookService bookService) {
		this.name = name;
		this.age = age;
		this.bookService = bookService;
	}
}

class BookService {}

class People {
	private Teacher teacher;

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "People{" +
				"teacher=" + teacher +
				'}';
	}
}

class Teacher {}
