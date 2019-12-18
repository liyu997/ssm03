package com.yShen.sys.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author 郑悦恺
 */
@Target(ElementType.METHOD)//注解的作用目标：方法
@Retention(RetentionPolicy.RUNTIME)//注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface PrivilegeInfo {

    String name() default "";


}
