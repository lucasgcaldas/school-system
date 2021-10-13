package com.totalcross.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for instantiate
 * a Grade
 * @author Lucas Gomes
 */
public class Grade {

    private String studentName;
    private String subjectName;
    private Double grade;
    private List<Subject> subjectList = new ArrayList<>();

    public Grade(Student studentName, SubjectEnum subjectName, Double grade) {
        this.studentName = studentName.getName();
        this.subjectName = subjectName.name();
        this.grade = grade;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student name = " + studentName +
                ", subject name = " + subjectName +
                ", grade = " + grade;
    }
}
