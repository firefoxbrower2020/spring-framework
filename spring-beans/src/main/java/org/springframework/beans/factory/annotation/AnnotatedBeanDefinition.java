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

package org.springframework.beans.factory.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.lang.Nullable;

/** 注解bean的实现类
 *  该接口继承了BeanDefinition，提供了一个getMetadata()方法来获取该bean definition的注解元数据。
 *
 * 其中，AnnotationMetadata定义了访问特定类的注解的抽象接口，它不需要加载该类即可访问。
 *
 * @author Juergen Hoeller
 * @since 2.5
 * @see AnnotatedGenericBeanDefinition
 * @see org.springframework.core.type.AnnotationMetadata
 */
public interface AnnotatedBeanDefinition extends BeanDefinition {

	/**
	 * Obtain the annotation metadata (as well as basic class metadata)
	 * for this bean definition's bean class.
	 * @return the annotation metadata object (never {@code null})
	 */
	AnnotationMetadata getMetadata();

	/**
	 * ClassMetadata定义了一个特定类的抽象元数据，不需要加载此类。主要方法如下：
	 * String getClassName()返回该类的名称。boolean isInterface()返回该类是否是接口。boolean isAbstract()返回该类是否为抽象类。
	 * boolean isConcrete()返回该类是否为具体类。boolean isFinal()返回该类是否为final类boolean hasSuperClass()返回该类是否有父类
	 * String getSuperClassName()返回父类的名称，没有的话返回null.
	 * String[] getInterfaceNames()返回继承的接口数组，如果没有，返回空.
	 * String[] getMemberClassNames()返回引用的类的名称。
	 */
	@Nullable
	MethodMetadata getFactoryMethodMetadata();

}
