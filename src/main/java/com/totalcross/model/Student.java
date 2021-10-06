package com.totalcross.model;

import java.math.BigInteger;
import java.util.UUID;

public class Student {

    private String name;
    private String code;

    public Student(String name) {
        this.name = name;
        this.code = generateCode();
    }

    private String generateCode() {
        return String.valueOf(new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 8);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Student name = " + name + " , code = " + code;
    }
}
