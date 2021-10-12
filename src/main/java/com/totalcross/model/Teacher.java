package com.totalcross.model;

import java.math.BigInteger;
import java.util.UUID;

public class Teacher {

    private String name;
    private String code;
    private SubjectEnum subjectEnum;

    public Teacher(String name, SubjectEnum subjectEnum) {
        this.name = name;
        this.subjectEnum = subjectEnum;
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
