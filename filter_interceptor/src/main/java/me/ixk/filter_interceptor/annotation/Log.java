package me.ixk.filter_interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Log {
    String value() default "";
}
