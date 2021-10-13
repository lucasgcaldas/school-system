package com.totalcross.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for instantiate
 * the subject
 * @author Lucas Gomes
 */
public class Subject {

    private SubjectEnum name;
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

    /**
     * method responsible for enroll the
     * student, add the student into list
     * and subtract the number of vacancies
     */
    public void enrollStudent(Student student) {
        students.add(student);
        vacancies--;
    }

    @Override
    public String toString() {
        return "Subject name = " + name +
                ", vacancies = " + vacancies +
                ", students = " + students;
    }
}

