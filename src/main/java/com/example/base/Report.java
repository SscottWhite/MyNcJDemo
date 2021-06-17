package com.example.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解
 * @author KJS_352
 * Target是元注解, 可以定义我们的注解用在哪些地方
 * @Retention元注解, 定义生命周期     RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。
 *
 */
@Target({
	ElementType.METHOD,
	ElementType.FIELD
})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Report {
	int type() default 0;
	String value() default "";
}
