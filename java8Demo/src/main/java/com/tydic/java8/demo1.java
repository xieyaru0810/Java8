package com.tydic.java8;

import org.junit.Test;

import java.util.*;

public class demo1 {

//    @Test
//    public void test1(){
//        Comparator<Integer> com  = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        };
//        TreeSet<Integer> set = new TreeSet<>(com);
//    }

    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> set = new TreeSet<>(com);
    }

    List emps = Arrays.asList(
            new Employee(1,"1",1),
            new Employee(2,"1",2),
            new Employee(3,"1",3)
    );

    //优化一：策略设计模式->调用的方法，传入的是接口的实现类。
    @Test
    public void test3(){
        List<Employee> l  = fileterEmployee(emps , new FilterEmployeeByAge());
        for(Employee e : l){
            System.out.println("age:"+e.getAge());
        }
    }
    //声明 的 方法，使用的是  接口。
    public List<Employee>  fileterEmployee(List<Employee> list , MyPredicate<Employee> mp){

        List<Employee> es =new ArrayList<>();
        for(Employee e : list){
            if(mp.test(e)){
                es.add(e);
            }
        }
        return es;
    }

    //优化二：匿名内部类。
    @Test
    public void test4(){
        List<Employee> es = fileterEmployee(emps,new MyPredicate<Employee>(){
            @Override
            public boolean test(Employee e) {
                return e.getAge()>1;
            }
        });

        for (Employee e : es){
            System.out.println("age : "+e.getAge());
        }
    }

    //优化三：lamda表达式
    @Test
    public void test5(){
        List<Employee> list = fileterEmployee(emps,(e) -> e.getAge() > 1);
        list.forEach(System.out::println);

    }


    //优化四：stream
    @Test
    public void test6(){
//        emps.stream().filter((a)-> a.getAge() > 1).limit(1).forEach(System.out::println);
//        emps.stream().map(Employee::getName).forEach(System.out::println);
        Integer n = operation(100,(e) -> e*e);
        System.out.println(n);
        Integer z = operation(200,(e) -> e+600);
        System.out.println(z);
    }

    public Integer operation(Integer o1, MyFfun my){
        return  my.getValue(o1);
    }





}
