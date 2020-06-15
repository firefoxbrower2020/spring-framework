/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.beans.factory;

/**
 BeanClassLoaderAware 允许一个获取它的classLoader(即当前bean factory加载bean类使用的class loader)的回调类，
 实现了void setBeanClassLoader(ClassLoader classLoader)方法

 void setBeanClassLoader(ClassLoader classLoader);
 *
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 2.0
 * @see BeanNameAware
 * @see BeanFactoryAware
 * @see InitializingBean
 */
public interface BeanClassLoaderAware extends Aware {

	/**
	 *
	 * 将BeanClassLoader提供给bean实例回调
	 * 在bean属性填充之后，初始化回调之前回调
	 * 例如：InitializingBean的InitializingBean.afterPropertiesSet()方法或自定义init方法
	 */
	void setBeanClassLoader(ClassLoader classLoader);

}
