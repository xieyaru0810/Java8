package com.tydic.java8;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private int age;
    private Status Status;

    public Employee(Integer z) {

    }

    public Employee() {

    }

    public Employee(Integer integer, String s) {
        this.id = integer;
        this.name = s;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }


    public Employee(int id, String name, int age, Employee.Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        Status = status;
    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee.Status getStatus() {
        return Status;
    }

    public void setStatus(Employee.Status status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }




}
