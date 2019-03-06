package com.tydic.java8;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee e) {
        return e.getAge()>1;
    }
}
