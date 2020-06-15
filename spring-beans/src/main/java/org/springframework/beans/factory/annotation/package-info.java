/**
 * Support package for annotation-driven bean configuration.
 *  配置基于注解驱动的bean的支持包。
 *  
 *  
 *  小结：
 *
 *  Spring3的基于注解实现Bean依赖注入支持如下三种注解：
 * Spring自带依赖注入注解： Spring自带的一套依赖注入注解；
 * JSR-250注解：Java平台的公共注解，是Java EE 5规范之一，在JDK6中默认包含这些注解，从Spring2.5开始支持。
 * JSR-330注解：Java 依赖注入标准，Java EE 6规范之一，可能在加入到未来JDK版本，从Spring3开始支持；
 其中，
 Spring自带依赖注入注解

 1 @Required：依赖检查；
 2 @Autowired：自动装配2 
 自动装配，用于替代基于XML配置的自动装配
 基于@Autowired的自动装配，默认是根据类型注入，可以用于构造器、字段、方法注入
 3 @Value：注入SpEL表达式
 用于注入SpEL表达式，可以放置在字段方法或参数上
 @Value(value = "SpEL表达式")  
 @Value(value = "#{message}")  
 4 @Qualifier：限定描述符，用于细粒度选择候选者
 @Qualifier限定描述符除了能根据名字进行注入，但能进行更细粒度的控制如何选择候选者
 @Qualifier(value = "限定标识符") 

 JSR-250注解

 1 @Resource：自动装配，默认根据类型装配，如果指定name属性将根据名字装配，可以使用如下方式来指定
 @Resource(name = "标识符")  
 字段或setter方法 

 2 @PostConstruct和PreDestroy：通过注解指定初始化和销毁方法定义

 JSR-330注解
 1 @Inject：等价于默认的@Autowired，只是没有required属性
 2 @Named：指定Bean名字，对应于Spring自带@Qualifier中的缺省的根据Bean名字注入情况
 3 @Qualifier：只对应于Spring自带@Qualifier中的扩展@Qualifier限定描述符注解，即只能扩展使用，没有value属性
 */
@NonNullApi
@NonNullFields
package org.springframework.beans.factory.annotation;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
