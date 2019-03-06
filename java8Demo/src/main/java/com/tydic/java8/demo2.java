package com.tydic.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class demo2 {

    List<Employee> emps = Arrays.asList(
            new Employee(1,"小明",41, Employee.Status.BUSY),
            new Employee(2,"玲玲",52,Employee.Status.VOCATION),
            new Employee(3,"莹莹",33,Employee.Status.FREE),
            new Employee(5,"张三",23,Employee.Status.BUSY),
            new Employee(4,"张三",23,Employee.Status.BUSY),
            new Employee(6,"李四",3,Employee.Status.VOCATION)
    );

    @Test
    public void test1() {
        boolean b1 = emps.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        boolean b2 = emps.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b1);
        System.out.println("-------------");
        System.out.println(b2);

        System.out.println("-------------");
        boolean b3 = emps.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);
        System.out.println("-------------");

        Optional<Employee> op = emps.stream().sorted(Comparator.comparingInt(Employee::getAge)).findAny();
        System.out.println(op.get());

        Optional<Employee> op1 = emps.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(op1);

        Optional<Integer> op2 = emps.stream().map(Employee::getAge).min(Integer::compare);
        System.out.println(op2);
    }


    @Test
    public void test2() {
        List<Integer> l = Arrays.asList(1,2,3,4,5);
        Integer num = l.stream().reduce(0,(x,y)->x+y);
        System.out.println("num="+num);
        Optional<Integer> op = emps.stream().map(Employee::getAge).reduce((x,y)->x+y);
        System.out.println(op.get());
    }
    @Test
    public void test3() {
        List<String> l = emps.stream().map(Employee::getName).collect(Collectors.toList());
        l.forEach(System.out::println);

        System.out.println("-------1------");

        HashSet<String> h = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        h.forEach(System.out::println);
        System.out.println("-------2------");

        Set<String> set  = emps.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }


    @Test
    public void test4() {
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);

        Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getAge));
        System.out.println(avg);

        Double av = emps.stream().collect(Collectors.summingDouble(Employee::getAge));
        System.out.println("sum="+av);

        Optional<Employee> a = emps.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println("maxby="+a);
    }
}


