package com.example.readin4;

public class Student {
    private String mssv;
    private String name;
    private int age;

    public Student(String mssv, String name, int age) {
        this.mssv = mssv;
        this.name = name;
        this.age = age;
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
