package com.totalcross.model;

import java.math.BigInteger;
import java.util.UUID;

public class Teacher {

    private String name;
    private String code;
    private Subject subject;

    public Teacher(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        this.code = generateCode();
    }

    private String generateCode() {
        return String.valueOf(new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Teacher name = " + name + " , code = " + code;
    }
}
