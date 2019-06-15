package org.springframework.context.frameworktest.qualifiertest.examp4;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shucheng on 2019-6-15 下午 22:19
 */

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface DataSourceType {
	String ip(); // 指定ip，用于多数据源情况
	DataBase database(); // 指定数据库类型
}
