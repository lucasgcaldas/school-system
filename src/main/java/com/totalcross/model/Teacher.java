package com.totalcross.model;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Class responsible for instantiate
 * a Teacher
 * @author Lucas Gomes
 */
public class Teacher {

    private String name;
    private String code;
    private SubjectEnum subjectEnum;

    public Teacher(String name, SubjectEnum subjectEnum) {
        this.name = name;
        this.subjectEnum = subjectEnum;
        this.code = generateCode();
    }

    /**
     * method responsible for generate
     * a unique registration code.
     * 9 numbers, ex: 123456789
     */
    private String generateCode() {
        return String.valueOf(new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 9);
    }

    @Override
    public String toString() {
        return "Teacher name = " + name + " , code = " + code;
    }
}
