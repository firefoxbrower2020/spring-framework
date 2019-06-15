package org.springframework.context.frameworktest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-15 下午 18:43
 * 测试bean标签里property标签
 */
public class ParsePropertyTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "parseProperty.xml";

	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT, getClass());
		StudentService1 studentService = (StudentService1) ctx.getBean("studentService1");
		System.out.println(studentService);
	}
}

class StudentService1 {

	private String name;
	private Integer age;
	private BookService1 bookService1;

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

	public BookService1 getBookService1() {
		return bookService1;
	}

	public void setBookService1(BookService1 bookService1) {
		this.bookService1 = bookService1;
	}
}

class BookService1 {}
