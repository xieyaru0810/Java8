package com.tydic.annotation;

        import java.lang.annotation.*;

        import static java.lang.annotation.ElementType.*;

/*
ElementType.TYPE_PARAMETER
使用这个注解，就可以在方法参数上，使用注解@MyAnnotation("abc")
 */
@Repeatable(value = MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "tydic";
}
