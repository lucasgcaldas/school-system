package com.totalcross.model;

/**
 * Enum responsible for instantiate
 * a set of subjects
 * @author Lucas Gomes
 */
public enum SubjectEnum {
    MATHEMATICS {
        @Override
        Integer getVacanciesNumber() {
            return 5;
        }
    },
    CHEMICAL {
        @Override
        Integer getVacanciesNumber() {
            return 4;
        }
    },
    BIOLOGY {
        @Override
        Integer getVacanciesNumber() {
            return 6;
        }
    },
    PHYSICAL {
        @Override
        Integer getVacanciesNumber() {
            return 3;
        }
    },
    ENGLISH {
        @Override
        Integer getVacanciesNumber() {
            return 5;
        }
    };

    /**
     * abstract method responsible for call
     * the number of vacancies in each subject
     */
    abstract Integer getVacanciesNumber();
}

