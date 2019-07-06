package com.kittycoder.awaretest;

import com.kittycoder.awaretest.po.MyApplicationAware;
import com.kittycoder.awaretest.po.People;
import com.kittycoder.awaretest.po.SpringContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-5 下午 20:48
 * 测试Aware
 */
public class GetContextTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/awaretest/spring-getcontext.xml";

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		System.out.println("======================================");
		System.out.println(SpringContext.getContext());

		SpringContext springContext = SpringContext.getBean("springContext");
		System.out.println(springContext);

		People zhangsan = SpringContext.getBean("zhangsan");
		System.out.println(zhangsan);

		/*People zhangsan1 = SpringContext.getBean(People.class);
		System.out.println(zhangsan1);*/

		/*People zhangsan2 = SpringContext.getBean("zhangsan", People.class);
		System.out.println(zhangsan2);*/

		MyApplicationAware myApplicationAware = SpringContext.getBean("myApplicationAware");
		System.out.println(myApplicationAware);
	}
}
