/*
 * Copyright 2002-2018 the original author or authors.
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
 * InitializingBean：实现此接口的bean在BeanFactory设置为它们的属性时只需要执行一次
 * 例如：初始化定制或者仅仅检查必须存在的属性是否已经设置完成等等。
 * void afterPropertiesSet() throws Exception;
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see DisposableBean
 * @see org.springframework.beans.factory.config.BeanDefinition#getPropertyValues()
 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getInitMethodName()
 */
public interface InitializingBean {

	/**
	 * 该方法在BeanFactory设置完了所有属性之后被调用
	 * 该方法允许bean实例设置了所有bean属性时执行初始化工作，如果该过程中出现了错误则需要抛出异常
	 *
	 */
	void afterPropertiesSet() throws Exception;

}
