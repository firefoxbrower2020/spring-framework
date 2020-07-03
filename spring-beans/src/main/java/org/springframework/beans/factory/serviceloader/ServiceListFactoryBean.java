/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.beans.factory.serviceloader;

import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 ServiceListFactoryBean：暴露配置的服务类的所有基础服务的FactoryBea，表现为一组服务对象，
 可以通过JDK1.6 serviceLoader基础类来获取这些服务。
 *
 * @author Juergen Hoeller
 * @since 2.5
 * @see java.util.ServiceLoader
 */
public class ServiceListFactoryBean extends AbstractServiceLoaderBasedFactoryBean implements BeanClassLoaderAware {

	@Override
	protected Object getObjectToExpose(ServiceLoader<?> serviceLoader) {
		List<Object> result = new LinkedList<>();
		for (Object loaderObject : serviceLoader) {
			result.add(loaderObject);
		}
		return result;
	}

	@Override
	public Class<?> getObjectType() {
		return List.class;
	}

}
