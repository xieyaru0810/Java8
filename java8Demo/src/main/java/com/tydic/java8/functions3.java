package com.tydic.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大核心函数：
 */
public class functions3 {
    @Test
    public void test1(){
        int num = 0;//jdk1.7以前 必须是 final
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("running"+num);
//            }
//        };

        Runnable r = ()-> System.out.println("as"+num);
        r.run();
    }

    List<Employee> es = Arrays.asList(
            new Employee(3,"3",3),
            new Employee(1,"1",1),
            new Employee(4,"4",1),
            new Employee(2,"2",2)
    );

    @Test
    public void test2(){
        System.out.println(filter("\t\t\t你好",(s)->s.length()>2));

        System.out.println(show("asdf",(z)->z.toUpperCase()));

        System.out.println(getNum(5,()->(int)(Math.random()*100)));

        consume(125,(z)-> System.out.println(z));
    }
    public static List<Integer> getNum(Integer num, Supplier<Integer> s){
        List<Integer> ls = new ArrayList<>();
        for (Integer i = 0; i < num; i++) {
            ls.add(s.get());
        }
        return ls;
    }
    public static String show(String s , Function<String,String> m){
        return m.apply(s);
    }
    public static void consume(Integer s , Consumer<Integer> m){
        m.accept(s);
    }
    public static List<String> filter(String s, Predicate<String> p){

        List<String> ls = new ArrayList<>();
        if(p.test(s)){
            ls.add(s);
        }

        return ls;
    }



}
