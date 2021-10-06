package com.totalcross.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private SubjectEnum name;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private Integer vacancies;

    public Subject(SubjectEnum name) {
        this.name = name;
        this.vacancies = name.getVacanciesNumber();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SubjectEnum getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void enrollStudent(Student student) {
        students.add(student);
        vacancies--;
    }

    public Integer getVacancies() {
        return vacancies;
    }
}

