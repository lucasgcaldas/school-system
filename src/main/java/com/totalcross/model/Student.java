package com.totalcross.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Class responsible for instantiate
 * a Student
 * @author Lucas Gomes
 */
public class Student {

    private String name;
    private String code;
    private List<Grade> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        this.code = generateCode();
    }

    /**
     * method responsible for generate
     * a unique registration code.
     * 8 numbers, ex: 12345678
     */
    private String generateCode() {
        return String.valueOf(new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16)).substring(0, 8);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    /**
     * method responsible for
     * enroll subjects, adding the
     * grades into list
     */
    public void enrollSubject(Grade grade) {
        grades.add(grade);
    }

    /**
     * method responsible for calculate
     * the average and the mode of grades
     * for each student
     */
    public String getSummary() {
        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        double maxValue = 0;
        double maxCount = 0;
        for (int i = 0; i < grades.size(); ++i) {
            int count = 0;
            for (Grade grade : grades) {
                if (Objects.equals(grade.getGrade(), grades.get(i).getGrade())) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = grades.get(i).getGrade();
            }
        }

        return "The total average = " + String.format("%.2f", sum / grades.size()) + '\n'
                + "The mode value = " + maxValue;
    }

    @Override
    public String toString() {
        return "Student name = " + name
                + ", code = " + code;
    }
}
