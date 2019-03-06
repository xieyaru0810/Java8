package com.tydic.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法的引用
 */
public class demo3 {

    @Test
    public void test1(){
        Consumer<String> z=  System.out::println;
        z.accept("zzzz");

        Employee e=  new Employee(1,"2",212);
        Supplier<String> s = ()->e.getName();
        System.out.println(s.get());

        Supplier<Integer> z0 = e::getAge;
        System.out.println(z0.get());

        Comparator<Integer> con = Integer::compare;
        System.out.println(con.compare(1,2));

//        lamda体的参数列表和返回值类型，与函数式接口中的返回值，保持一致。

        Supplier<Employee> s1 = ()->new Employee(1,"1",1);
        System.out.println(s1.get());

        Supplier<Employee> z1 = Employee::new;
        System.out.println(z1.get());

        Function<Integer,Employee> c=  Employee::new;
        Employee x= c.apply(1);
        System.out.println(x);

        BiFunction<Integer,String,Employee> b = Employee::new;
        Employee a = b.apply(1,"1");
        System.out.println(a);

        Function<Integer,String[]> f = String[]::new;
        String[] a1 = f.apply(20);
        System.out.println(a1.length);
    }

    List<Employee> es = Arrays.asList(
            new Employee(3,"3",3),
            new Employee(1,"1",1),
            new Employee(4,"4",1),
            new Employee(2,"2",2)
    );
    /*
     Map和flatMap的区别：
        1.map---接受Lamda，将元素转换成其他形式或提取信息，
          该函数会被应用到每个元素，并将其映射成一个新的元素。
        2.flatmap---接收一个函数作为参数，将流中的每个值
          都换成顶一个流，然后把所有流转换成一个流。
     */
    @Test
    public void test2(){

        List<String> ls = Arrays.asList("zzzz","aa","ccc","ddd");


    }


}
