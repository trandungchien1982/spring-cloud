package com.example.demo.model;

public class Teacher2 {
    String name2;
    String message2;
    String className2;
    int age2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getClassName2() {
        return className2;
    }

    public void setClassName2(String className2) {
        this.className2 = className2;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    @Override
    public String toString() {
        return "Teacher2{" +
                "name2='" + name2 + '\'' +
                ", message2='" + message2 + '\'' +
                ", className2='" + className2 + '\'' +
                ", age2=" + age2 +
                '}';
    }
}
