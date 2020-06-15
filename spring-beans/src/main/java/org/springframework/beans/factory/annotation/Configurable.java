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

package org.springframework.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  public @interface Configurable @Configurable 注解中的autowire属性就可以让Spring来自动装配了：
 *  @Configurable(autowire=Autowire.BY_TYPE) 或者 @Configurable(autowire=Autowire.BY_NAME，这样就可以按类型或者按名字自动装配了。
 *
 * @author Rod Johnson
 * @author Rob Harrop
 * @author Adrian Colyer
 * @author Ramnivas Laddad
 * @since 2.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Configurable {

	/**
	 * The name of the bean definition that serves as the configuration template.
	 */
	String value() default "";

	/**
	 * Are dependencies to be injected via autowiring?
	 */
	Autowire autowire() default Autowire.NO;

	/**
	 * Is dependency checking to be performed for configured objects?
	 */
	boolean dependencyCheck() default false;

	/**
	 * Are dependencies to be injected prior to the construction of an object?
	 */
	boolean preConstruction() default false;

}
