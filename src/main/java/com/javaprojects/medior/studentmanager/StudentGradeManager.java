package com.javaprojects.medior.studentmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StudentGradeManager - Medior Level
 *
 * Demonstrates:
 * - Generics and Collections (List, Map)
 * - Java Streams for filtering, sorting, and grouping
 * - Inner classes / records (Student)
 * - Calculating statistics (average, highest/lowest grade)
 */
public class StudentGradeManager {

    private final List<Student> students;

    public StudentGradeManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the manager.
     *
     * @param student the student to add
     * @throws IllegalArgumentException if a student with the same name already exists
     */
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        boolean exists = students.stream()
                .anyMatch(s -> s.getName().equalsIgnoreCase(student.getName()));
        if (exists) {
            throw new IllegalArgumentException("Student already exists: " + student.getName());
        }
        students.add(student);
    }

    /**
     * Finds a student by name (case-insensitive).
     *
     * @param name the student's name
     * @return an Optional containing the student, or empty if not found
     */
    public Optional<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Returns all students sorted by grade in descending order.
     *
     * @return a new sorted list
     */
    public List<Student> getRanking() {
        return students.stream()
                .sorted((a, b) -> Double.compare(b.getGrade(), a.getGrade()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the average grade of all students.
     *
     * @return the average grade, or 0.0 if no students are registered
     */
    public double getAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    /**
     * Returns the student with the highest grade.
     *
     * @return an Optional containing the top student, or empty if no students exist
     */
    public Optional<Student> getTopStudent() {
        return students.stream()
                .max((a, b) -> Double.compare(a.getGrade(), b.getGrade()));
    }

    /**
     * Returns the student with the lowest grade.
     *
     * @return an Optional containing the bottom student, or empty if no students exist
     */
    public Optional<Student> getBottomStudent() {
        return students.stream()
                .min((a, b) -> Double.compare(a.getGrade(), b.getGrade()));
    }

    /**
     * Groups students by their letter grade (A, B, C, D, F).
     *
     * @return a map from letter grade to list of students
     */
    public Map<String, List<Student>> groupByLetterGrade() {
        return students.stream()
                .collect(Collectors.groupingBy(s -> Student.letterGrade(s.getGrade())));
    }

    /**
     * Returns an unmodifiable view of all students.
     *
     * @return unmodifiable list of students
     */
    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public static void main(String[] args) {
        StudentGradeManager manager = new StudentGradeManager();
        manager.addStudent(new Student("Alice", 92.5));
        manager.addStudent(new Student("Bob", 78.0));
        manager.addStudent(new Student("Charlie", 85.0));
        manager.addStudent(new Student("Diana", 65.0));
        manager.addStudent(new Student("Eve", 55.0));

        System.out.println("=== Student Grade Manager ===");
        System.out.printf("Average grade: %.1f%n", manager.getAverageGrade());
        manager.getTopStudent().ifPresent(s ->
                System.out.println("Top student: " + s));
        manager.getBottomStudent().ifPresent(s ->
                System.out.println("Bottom student: " + s));

        System.out.println("\nRanking:");
        manager.getRanking().forEach(s -> System.out.println("  " + s));

        System.out.println("\nGrouped by letter grade:");
        manager.groupByLetterGrade().forEach((letter, list) ->
                System.out.println("  " + letter + ": " + list));
    }
}
