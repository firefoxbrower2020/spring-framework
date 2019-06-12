package org.springframework.context.frameworktest;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-11 下午 22:05
 * 测试bean标签里的meta标签和loopup-method属性
 * 参考了CglibProxyTests的写法
 *
 */
public class ParseLookupMethodTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "parseLookupMethod.xml";

	@Test
	public void test1() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT, getClass());
		Display display = (Display) ctx.getBean("display");
		display.display();
	}
}

abstract class Display {

	private String displayId;

	public void display() {
		getCar().display();
	}

	public abstract Car getCar();

	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}
}

interface Car {

	void display();
}

class Hongqi implements Car {
	@Override
	public void display() {
		System.out.println("我是hongqi");
	}
}

class Bmw implements Car {
	@Override
	public void display() {
		System.out.println("我是BMW");
	}
}
