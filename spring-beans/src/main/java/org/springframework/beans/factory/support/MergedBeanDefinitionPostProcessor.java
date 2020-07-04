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

package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 MergedBeanDefinitionPostProcessor：后处理回调接口，在运行时合并bean definition。
 * 
 * BeanPostProcessor 是一个可以定制修改一个新的bean实例的工厂钩子，例如：检查marker接口或者使用代理包装他们。
 * applicationContext 可以在他们的bean容器中自动识别BeanPostProcessor bean，
 * 并将它们应用到接下来所创建的bean。一般的bean factory通过编程来注册Post-processor，并将它们应用到整个bean factory创建bean的过程中。
 *
 * 通常意义上，post-processor 设置bean属性通过marker 接口或者类似于实现postProcessBeforeInitialization(java.lang.Object, java.lang.String)；
 * 使用代理包装bean通常实现postProcessAfterInitialization(java.lang.Object, java.lang.String).
 *
 * @author Juergen Hoeller
 * @since 2.5
 * @see org.springframework.beans.factory.config.ConfigurableBeanFactory#getMergedBeanDefinition
 */
public interface MergedBeanDefinitionPostProcessor extends BeanPostProcessor {

	/**
	 * Post-process the given merged bean definition for the specified bean.
	 * @param beanDefinition the merged bean definition for the bean
	 * @param beanType the actual type of the managed bean instance
	 * @param beanName the name of the bean
	 * @see AbstractAutowireCapableBeanFactory#applyMergedBeanDefinitionPostProcessors
	 */
	void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName);

	/**
	 * A notification that the bean definition for the specified name has been reset,
	 * and that this post-processor should clear any metadata for the affected bean.
	 * <p>The default implementation is empty.
	 * @param beanName the name of the bean
	 * @since 5.1
	 * @see DefaultListableBeanFactory#resetBeanDefinition
	 */
	default void resetBeanDefinition(String beanName) {
	}

}
