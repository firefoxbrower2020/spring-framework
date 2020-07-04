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

package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.lang.Nullable;

/**
 GenericBeanDefinition：通用BeanDefinition是一站式的标准bean Definition
 *  GenericBeanDefinition主要用来测试AnnotatedBeanDefinition上的操作的，
 *  例如：在spring的component扫描支持的实现中（默认实现类是ScannedGenericBeanDefinition，
 *  它同样实现了AnnotatedBeanDefinition接口

 GenericBeanDefinition是一站式的标准bean definition，
 除了具有指定类、可选的构造参数值和属性参数这些其它bean definition一样的特性外，
 它还具有通过parenetName属性来灵活设置parent bean definition。
 通常， GenericBeanDefinition用来注册用户可见的bean definition
 (可见的bean definition意味着可以在该类bean definition上定义post-processor来对bean进行操作，甚至为配置parent name做扩展准备)。
 RootBeanDefinition / ChildBeanDefinition用来预定义具有parent/child关系的bean definition
 
 
 * @author Juergen Hoeller
 * @since 2.5
 * @see #setParentName
 * @see RootBeanDefinition
 * @see ChildBeanDefinition
 */
@SuppressWarnings("serial")
public class GenericBeanDefinition extends AbstractBeanDefinition {

	@Nullable
	private String parentName;


	/**
	 * Create a new GenericBeanDefinition, to be configured through its bean
	 * properties and configuration methods.
	 * @see #setBeanClass
	 * @see #setScope
	 * @see #setConstructorArgumentValues
	 * @see #setPropertyValues
	 */
	public GenericBeanDefinition() {
		super();
	}

	/**
	 * Create a new GenericBeanDefinition as deep copy of the given
	 * bean definition.
	 * @param original the original bean definition to copy from
	 */
	public GenericBeanDefinition(BeanDefinition original) {
		super(original);
	}


	@Override
	public void setParentName(@Nullable String parentName) {
		this.parentName = parentName;
	}

	@Override
	@Nullable
	public String getParentName() {
		return this.parentName;
	}


	@Override
	public AbstractBeanDefinition cloneBeanDefinition() {
		return new GenericBeanDefinition(this);
	}

	@Override
	public boolean equals(Object other) {
		return (this == other || (other instanceof GenericBeanDefinition && super.equals(other)));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Generic bean");
		if (this.parentName != null) {
			sb.append(" with parent '").append(this.parentName).append("'");
		}
		sb.append(": ").append(super.toString());
		return sb.toString();
	}

}
