package com.kittycoder.processenginefactorybean;

import com.kittycoder.processenginefactorybean.engine.MyProcessEngine;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2019-8-12 下午 21:49
 */
public class ProcessEngineFactoryBeanTest {

	private static final String DEPENDENCY_CHECK_CONTEXT = "com/kittycoder/processenginefactorybean/myactiviti-context.xml";

	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(DEPENDENCY_CHECK_CONTEXT);
		MyProcessEngine myProcessEngine = (MyProcessEngine) ctx.getBean("myProcessEngine");
		System.out.println(myProcessEngine);
		myProcessEngine.close();
	}
}
