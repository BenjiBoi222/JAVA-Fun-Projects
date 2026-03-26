package com.javaprojects.medior.studentmanager;

/**
 * Represents a student with a name and a numeric grade (0-100).
 */
public class Student {

    private final String name;
    private double grade;

    public Student(String name, double grade) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank.");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }

    /**
     * Converts a numeric grade (0-100) to a letter grade.
     *
     * @param grade the numeric grade
     * @return "A", "B", "C", "D", or "F"
     */
    public static String letterGrade(double grade) {
        if (grade >= 90) return "A";
        if (grade >= 80) return "B";
        if (grade >= 70) return "C";
        if (grade >= 60) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("Student[name=%s, grade=%.1f (%s)]",
                name, grade, letterGrade(grade));
    }
}
