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

package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.wiring.BeanWiringInfo;
import org.springframework.beans.factory.wiring.BeanWiringInfoResolver;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 *@configurable注解实现AnnotationBeanWiringInfoResolver
 * 设置 @Configurable 注解中的autowire属性就可以让Spring来自动装配了：
 * @Configurable(autowire=Autowire.BY_TYPE) 或者 @Configurable(autowire=Autowire.BY_NAME，这样就可以按类型或者按名字自动装配了
 * 
 * 
 * AnnotationBeanWiringInfoResolver 继承自BeanWiringInfoResolver，
 * BeanWiringInfoResolver使用configurable注解来查找哪些类需要自动绑定。
 * 实现了BeanWiringInfoResolver的resolveWiringInfo方法
 */
public class AnnotationBeanWiringInfoResolver implements BeanWiringInfoResolver {

	@Override
	@Nullable
	public BeanWiringInfo resolveWiringInfo(Object beanInstance) {
		Assert.notNull(beanInstance, "Bean instance must not be null");
		Configurable annotation = beanInstance.getClass().getAnnotation(Configurable.class);
		return (annotation != null ? buildWiringInfo(beanInstance, annotation) : null);
	}

	/**
	 * Build the {@link BeanWiringInfo} for the given {@link Configurable} annotation.
	 * @param beanInstance the bean instance
	 * @param annotation the Configurable annotation found on the bean class
	 * @return the resolved BeanWiringInfo
	 */
	protected BeanWiringInfo buildWiringInfo(Object beanInstance, Configurable annotation) {
		if (!Autowire.NO.equals(annotation.autowire())) {
			// Autowiring by name or by type
			return new BeanWiringInfo(annotation.autowire().value(), annotation.dependencyCheck());
		}
		else if (!"".equals(annotation.value())) {
			// Explicitly specified bean name for bean definition to take property values from
			return new BeanWiringInfo(annotation.value(), false);
		}
		else {
			// Default bean name for bean definition to take property values from
			return new BeanWiringInfo(getDefaultBeanName(beanInstance), true);
		}
	}

	/**
	 * Determine the default bean name for the specified bean instance.
	 * <p>The default implementation returns the superclass name for a CGLIB
	 * proxy and the name of the plain bean class else.
	 * @param beanInstance the bean instance to build a default name for
	 * @return the default bean name to use
	 * @see org.springframework.util.ClassUtils#getUserClass(Class)
	 */
	protected String getDefaultBeanName(Object beanInstance) {
		return ClassUtils.getUserClass(beanInstance).getName();
	}

}
