package com.TomaszB.Lab1;

public class User{
    public String name;
    public int age;

    public User() {
    }

    public String getName() {
        return name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
}