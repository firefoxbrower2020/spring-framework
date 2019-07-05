package com.kittycoder.circledependency;

import com.kittycoder.circledependency.po.Husband;
import com.kittycoder.circledependency.po.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-7-4 下午 22:34
 * 循环依赖测试
 */
public class CircledependencyTest {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/kittycoder/circledependency/spring-circledependency.xml");
		Husband husband = (Husband) ac.getBean("husband");
		System.out.println(husband);
		Wife wife = (Wife) ac.getBean("wife");
		System.out.println(wife);
	}
}
