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

package org.springframework.beans.factory.parsing;

import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 Location：模型接口，一个资源位置的模型
 *
 * @author Rob Harrop
 * @since 2.0
 */
public class Location {

	private final Resource resource;

	@Nullable
	private final Object source;


	/**
	 * Create a new instance of the {@link Location} class.
	 * @param resource the resource with which this location is associated
	 */
	public Location(Resource resource) {
		this(resource, null);
	}

	/**
	 * Create a new instance of the {@link Location} class.
	 * @param resource the resource with which this location is associated
	 * @param source the actual location within the associated resource
	 * (may be {@code null})
	 */
	public Location(Resource resource, @Nullable Object source) {
		Assert.notNull(resource, "Resource must not be null");
		this.resource = resource;
		this.source = source;
	}


	/**
	 * Get the resource with which this location is associated.
	 */
	public Resource getResource() {
		return this.resource;
	}

	/**
	 * Get the actual location within the associated {@link #getResource() resource}
	 * (may be {@code null}).
	 * <p>See the {@link Location class level javadoc for this class} for examples
	 * of what the actual type of the returned object may be.
	 */
	@Nullable
	public Object getSource() {
		return this.source;
	}

}
