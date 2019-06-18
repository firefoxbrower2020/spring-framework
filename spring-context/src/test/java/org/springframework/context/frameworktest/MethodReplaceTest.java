package org.springframework.context.frameworktest;

import org.junit.Test;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

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
	/**
	 * obj是原对象的动态代理对象
	 * method原对象被替换的新方法
	 * args是原方法被调用时传进来的参数
	 */
	@Override
	public Object reimplement(Object obj, java.lang.reflect.Method method, Object[] args) throws Throwable {
		System.out.println("我是替换方法");

		// 获取动态代理的被代理对象
		Field h = obj.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		h.setAccessible(true);

		// 获取cglib动态代理的真实class
		// 参考：net.sf.cglib.proxy.NoOp NoOp回调把对方法调用直接委派到这个方法在父类中的实现（https://www.cnblogs.com/shijiaqi1066/p/3429691.html）
		Class originalClazz = (Class) h.getDeclaringClass().getGenericSuperclass();
		System.out.println(originalClazz);
		method.invoke(originalClazz.newInstance(), null);

		// 网上能看到的基本都是下面这两种（第一种最多），但根本解决不了问题
		// https://juejin.im/post/5a336317f265da43133d32ba
		// https://www.thekua.com/atwork/2011/06/finding-real-object-under-spring-proxies/
		return null;
	}
}