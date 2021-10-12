package com.totalcross.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private SubjectEnum name;
    private List<Grade> grades = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private int vacancies;

    public Subject(SubjectEnum name) {
        this.name = name;
        this.vacancies = name.getVacanciesNumber();
    }

    public SubjectEnum getName() {
        return name;
    }

    public int getVacancies() {
        return this.vacancies;
    }

    public void enrollStudent(Student student, Grade grade) {
        students.add(student);
        grades.add(grade);
        vacancies--;
    }

    @Override
    public String toString() {
        return  "Subject name = " + name +
                ", vacancies = " + vacancies +
                ", grades = " + grades +
                ", students = " + students;
    }
}

