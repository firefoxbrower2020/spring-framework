package org.springframework.beans.factory.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shucheng on 2019-5-31 下午 14:41
 * https://blog.csdn.net/u010999809/article/details/90714183
 */
public class MySchema {

	public static final String DEFAULT_SCHEMA_MAPPINGS_LOCATION = "META-INF/spring.schemas";

	private final ClassLoader classLoader;

	private String schemaMappingsLocation;

	private Map<String, String> schemaMappings;

	public MySchema(ClassLoader classLoader) {
		this.classLoader = classLoader;
		this.schemaMappingsLocation = DEFAULT_SCHEMA_MAPPINGS_LOCATION;
	}

	public Map<String, String> getSchemaMappings() {
		Map<String, String> schemaMappings = this.schemaMappings;
		// 如果schemaMappings不为null，则直接返回数据，不需要重新创建对象
		if (schemaMappings == null) {
			System.out.println("线程" + Thread.currentThread().getName() + "进入if判断");
			synchronized (this) {
				System.out.println("线程" + Thread.currentThread().getName() + "进入同步锁");
				System.out.println("线程" + Thread.currentThread().getName() + "\n" +
						"schemaMappings=====" + (schemaMappings != null ? schemaMappings.hashCode() : null) + "\n" +
						"this.schemaMappings=====" + (this.schemaMappings != null ? this.schemaMappings.hashCode() : null));

				schemaMappings = this.schemaMappings;
				if (schemaMappings == null) {
					System.out.println("开始加载schemaMappingsLocation");
					Map<String, String> map = new HashMap();
					map.put("1", "张三");
					map.put("2", "李四");
					map.put("3", "王五");
					map.put("4", "赵六");
					map.put("5", "钱七");

					schemaMappings = new HashMap<>();
					schemaMappings.putAll(map);
					System.out.println("schemaMappingsLocation加载中");

					this.schemaMappings = schemaMappings;
					System.out.println("schemaMappingsLocation加载完成");
				}
			}
		}
		System.out.println("线程" + Thread.currentThread().getName() + "======class为" + schemaMappings.getClass().hashCode() + "=====" + schemaMappings);
		return schemaMappings;
	}

	@Override
	public String toString() {
		return "MySchema{" +
				"schemaMappings=" + getSchemaMappings() +
				'}';
	}
}
