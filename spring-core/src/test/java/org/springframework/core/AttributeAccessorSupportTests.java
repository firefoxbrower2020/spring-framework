/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 AttributeAccessor 赋值相关操作
 */
public class AttributeAccessorSupportTests {

	private static final String NAME = "foo";

	private static final String VALUE = "bar";
	
	@SuppressWarnings("serial")
	//如果一个类要被声明为static的，只有一种情况，就是静态内部类。
	// 如果在外部类声明为static，程序会编译都不会过。
	// 在一番调查后个人总结出了3点关于内部类和静态内部类（俗称：内嵌类）
	private static class SimpleAttributeAccessorSupport extends AttributeAccessorSupport {
	}
	private AttributeAccessor attributeAccessor = new SimpleAttributeAccessorSupport();



	@Test
	public void setAndGet() throws Exception {
		this.attributeAccessor.setAttribute(NAME, VALUE);
		assertEquals(VALUE, this.attributeAccessor.getAttribute(NAME));
	}

	@Test
	public void setAndHas() throws Exception {
		assertFalse(this.attributeAccessor.hasAttribute(NAME));
		this.attributeAccessor.setAttribute(NAME, VALUE);
		assertTrue(this.attributeAccessor.hasAttribute(NAME));
	}

	@Test
	public void remove() throws Exception {
		assertFalse(this.attributeAccessor.hasAttribute(NAME));
		this.attributeAccessor.setAttribute(NAME, VALUE);
		assertEquals(VALUE, this.attributeAccessor.removeAttribute(NAME));
		assertFalse(this.attributeAccessor.hasAttribute(NAME));
	}

	@Test
	public void attributeNames() throws Exception {
		this.attributeAccessor.setAttribute(NAME, VALUE);
		this.attributeAccessor.setAttribute("abc", "123");
		String[] attributeNames = this.attributeAccessor.attributeNames();
		Arrays.sort(attributeNames);
		assertTrue(Arrays.binarySearch(attributeNames, NAME) > -1);
		assertTrue(Arrays.binarySearch(attributeNames, "abc") > -1);
	}

	
}
