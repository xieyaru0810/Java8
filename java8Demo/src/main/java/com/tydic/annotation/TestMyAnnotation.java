package com.tydic.annotation;

import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.lang.reflect.Method;

/*
重复注解与类型注解
 */
public class TestMyAnnotation {

    //java8还没有内置对象，使用框架(checker freamwork 提供了编译器)来使用。
    private @Nullable  Object obj ;
    @Test
    public void test1() throws Exception {
        Class<TestMyAnnotation> clazz = TestMyAnnotation.class;
        Method m = clazz.getMethod("show");
        MyAnnotation [] ms = m.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : ms) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str ){

        System.out.println("aaaaaa");
    }
}
