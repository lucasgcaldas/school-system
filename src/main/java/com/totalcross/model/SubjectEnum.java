package com.totalcross.model;

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

    abstract Integer getVacanciesNumber();
}

