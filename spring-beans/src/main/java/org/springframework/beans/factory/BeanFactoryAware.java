/*
 * Copyright 2002-2012 the original author or authors.
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

import org.springframework.beans.BeansException;

/**
 *  BeanFactoryAware实现此接口的bean可以获取到它们自己的Beanfactory。
 *
 * @author Rod Johnson
 * @author Chris Beams
 * @since 11.03.2003
 * @see BeanNameAware
 * @see BeanClassLoaderAware
 * @see InitializingBean
 * @see org.springframework.context.ApplicationContextAware
 */
public interface BeanFactoryAware extends Aware {

	/**
	 * Callback that supplies the owning factory to a bean instance.
	 * <p>Invoked after the population of normal bean properties
	 * but before an initialization callback such as
	 * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
	 * @param beanFactory owning BeanFactory (never {@code null}).
	 * The bean can immediately call methods on the factory.
	 * @throws BeansException in case of initialization errors
	 * @see BeanInitializationException
	 *
	 * 将BeanFactory提供给bean实例回调
	 * 调用时机和setBeanClassLoader一样
	 */
	void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
