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

import org.springframework.beans.FatalBeanException;

/**
 *FactoryBeanNotInitializedException：工厂bean没有初始化异常。
 *
 * @author Juergen Hoeller
 * @since 30.10.2003
 * @see FactoryBean#getObject()
 */
@SuppressWarnings("serial")
public class FactoryBeanNotInitializedException extends FatalBeanException {

	/**
	 * Create a new FactoryBeanNotInitializedException with the default message.
	 */
	public FactoryBeanNotInitializedException() {
		super("FactoryBean is not fully initialized yet");
	}

	/**
	 * Create a new FactoryBeanNotInitializedException with the given message.
	 * @param msg the detail message
	 */
	public FactoryBeanNotInitializedException(String msg) {
		super(msg);
	}

}
