package com.javaprojects.medior.studentmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentGradeManagerTest {

    private StudentGradeManager manager;

    @BeforeEach
    void setUp() {
        manager = new StudentGradeManager();
        manager.addStudent(new Student("Alice", 92.5));
        manager.addStudent(new Student("Bob", 78.0));
        manager.addStudent(new Student("Charlie", 85.0));
        manager.addStudent(new Student("Diana", 65.0));
        manager.addStudent(new Student("Eve", 55.0));
    }

    @Test
    void addStudent_duplicateName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addStudent(new Student("Alice", 70.0)));
    }

    @Test
    void addStudent_nullStudent_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addStudent(null));
    }

    @Test
    void findByName_existingStudent_returnsStudent() {
        Optional<Student> result = manager.findByName("Alice");
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());
    }

    @Test
    void findByName_caseInsensitive_returnsStudent() {
        Optional<Student> result = manager.findByName("alice");
        assertTrue(result.isPresent());
    }

    @Test
    void findByName_nonExistingStudent_returnsEmpty() {
        Optional<Student> result = manager.findByName("Unknown");
        assertFalse(result.isPresent());
    }

    @Test
    void getRanking_returnsSortedByGradeDescending() {
        List<Student> ranking = manager.getRanking();
        assertEquals(5, ranking.size());
        assertEquals("Alice", ranking.get(0).getName());  // 92.5
        assertEquals("Charlie", ranking.get(1).getName()); // 85.0
        assertEquals("Bob", ranking.get(2).getName());     // 78.0
        assertEquals("Diana", ranking.get(3).getName());   // 65.0
        assertEquals("Eve", ranking.get(4).getName());     // 55.0
    }

    @Test
    void getAverageGrade_fiveStudents_returnsCorrectAverage() {
        double expected = (92.5 + 78.0 + 85.0 + 65.0 + 55.0) / 5.0;
        assertEquals(expected, manager.getAverageGrade(), 0.001);
    }

    @Test
    void getAverageGrade_emptyManager_returnsZero() {
        StudentGradeManager empty = new StudentGradeManager();
        assertEquals(0.0, empty.getAverageGrade());
    }

    @Test
    void getTopStudent_returnsStudentWithHighestGrade() {
        Optional<Student> top = manager.getTopStudent();
        assertTrue(top.isPresent());
        assertEquals("Alice", top.get().getName());
    }

    @Test
    void getBottomStudent_returnsStudentWithLowestGrade() {
        Optional<Student> bottom = manager.getBottomStudent();
        assertTrue(bottom.isPresent());
        assertEquals("Eve", bottom.get().getName());
    }

    @Test
    void groupByLetterGrade_correctGroupings() {
        Map<String, List<Student>> groups = manager.groupByLetterGrade();
        assertTrue(groups.containsKey("A"));
        assertTrue(groups.containsKey("B"));
        assertTrue(groups.containsKey("C"));
        assertTrue(groups.containsKey("D"));
        assertTrue(groups.containsKey("F"));

        assertEquals(1, groups.get("A").size()); // Alice 92.5
        assertEquals(1, groups.get("B").size()); // Charlie 85.0
        assertEquals(1, groups.get("C").size()); // Bob 78.0
        assertEquals(1, groups.get("D").size()); // Diana 65.0
        assertEquals(1, groups.get("F").size()); // Eve 55.0
    }

    @Test
    void letterGrade_correctMapping() {
        assertEquals("A", Student.letterGrade(90));
        assertEquals("A", Student.letterGrade(100));
        assertEquals("B", Student.letterGrade(80));
        assertEquals("B", Student.letterGrade(89));
        assertEquals("C", Student.letterGrade(70));
        assertEquals("C", Student.letterGrade(79));
        assertEquals("D", Student.letterGrade(60));
        assertEquals("D", Student.letterGrade(69));
        assertEquals("F", Student.letterGrade(59));
        assertEquals("F", Student.letterGrade(0));
    }

    @Test
    void student_invalidGrade_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Test", -1));
        assertThrows(IllegalArgumentException.class, () -> new Student("Test", 101));
    }

    @Test
    void student_blankName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student("", 80));
    }
}
