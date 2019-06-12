package org.springframework.context.frameworktest;

import org.junit.Test;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-6-11 下午 23:21
 * 测试bean标签里的replaced-method标签
 */
public class MethodReplaceTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "methodReplace.xml";

	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT, getClass());
		Method method = (Method) ctx.getBean("method");
		method.display();
	}
}

class Method {

	public void display() {
		System.out.println("我是原始方法");
	}
}

class MethodReplace implements MethodReplacer {
	@Override
	public Object reimplement(Object obj, java.lang.reflect.Method method, Object[] args) throws Throwable {
		System.out.println("我是替换方法");
		return null;
	}
}