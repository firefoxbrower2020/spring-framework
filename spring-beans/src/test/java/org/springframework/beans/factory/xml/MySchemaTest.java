package org.springframework.beans.factory.xml;

import org.junit.Test;

import java.util.Map;

/**
 * Created by shucheng on 2019-5-31 下午 14:42
 * PluggableSchemaResolver中加载schemas（getSchemaMappings方法，该方法使用了饿汉式单例模式-双重检查锁）
 * 测试getSchemaMappings方法，可以用org.springframework.beans.factory.xml.XmlBeanDefinitionReaderTests#withOpenInputStreamAndExplicitValidationMode()
 *
 * 对PluggableSchemaResolver模仿后写的一个类MySchema进行测试（单线程和多线程情况）
 */
public class MySchemaTest {

	// 简单测试
	@Test
	public void test() {
		MySchema m = new MySchema(getClass().getClassLoader());
		System.out.println(m);
		// System.out.println(m.toString());
	}

	// 模拟多线程（3个线程）测试
	// 参考链接：https://www.jb51.net/article/130924.htm
	// 另外还参考了MyBatis3.5.1源码里的单元测试org.apache.ibatis.io.VFSTest#getInstanceShouldNotBeNullInMultiThreadEnv
	@Test
	public void testMultiThread() {
		final int threadCount = 20;
		Thread[] threads = new Thread[threadCount];
		InstanceGetterProcedure procedure = new InstanceGetterProcedure(new MySchema(getClass().getClassLoader()));

		for (int i = 0; i < threads.length; i++) {
			String threadName = "Thread##" + i;
			threads[i] = new Thread(procedure, threadName);
		}

		for (Thread thread : threads) {
			thread.start();
		}
	}

	private class InstanceGetterProcedure implements Runnable {

		private MySchema mySchema;
		Map<String, String> schemaMappings;

		public InstanceGetterProcedure() {
		}

		public InstanceGetterProcedure(MySchema mySchema) {
			this.mySchema = mySchema;
		}

		@Override
		public void run() {
			// 获取schemaMappings
			schemaMappings = mySchema.getSchemaMappings();
		}
	}
}
