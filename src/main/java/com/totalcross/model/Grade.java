package com.totalcross.model;

public class Grade {

    private String studentName;
    private String subjectName;
    private Double grade;

    public Grade(Student studentName, SubjectEnum subjectName, Double grade) {
        this.studentName = studentName.getName();
        this.subjectName = subjectName.name();
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student name = " + studentName +
                ", subject name = " + subjectName +
                ", grade = " + grade;
    }
}
