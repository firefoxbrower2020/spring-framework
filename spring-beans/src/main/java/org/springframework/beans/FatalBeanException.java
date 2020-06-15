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

package org.springframework.beans;

import org.springframework.lang.Nullable;

/**
 * FatalBeanException： 在bean包和子包中遇到的不可恢复问题抛出的异常，
 * 例如：当引用一个无效的bean属性时抛出的InvalidPropertyException异常
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
public class FatalBeanException extends BeansException {

	/**
	 * Create a new FatalBeanException with the specified message.
	 * @param msg the detail message
	 */
	public FatalBeanException(String msg) {
		super(msg);
	}

	/**
	 * Create a new FatalBeanException with the specified message
	 * and root cause.
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	public FatalBeanException(String msg, @Nullable Throwable cause) {
		super(msg, cause);
	}

}
