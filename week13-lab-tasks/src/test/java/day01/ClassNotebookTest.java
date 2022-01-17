package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void addStudentTest() {

        ClassNotebook classNotebook = new ClassNotebook();
        Student s = new Student(1, "John");
        classNotebook.addStudent(s);

        assertTrue(classNotebook.getNotebook().keySet().contains(s));
        assertEquals(0, classNotebook.getNotebook().get(s).size());
    }

    @Test
    void addStudentInOrderTest() {

        ClassNotebook classNotebook = new ClassNotebook();

        Student s = new Student(1, "John");
        Student s2 = new Student(3, "John");
        Student s3 = new Student(2, "John");
        classNotebook.addStudent(s);
        classNotebook.addStudent(s2);
        classNotebook.addStudent(s3);

        assertEquals(List.of(s, s3, s2), new ArrayList<>(classNotebook.getNotebook().keySet()));

        int i = 1;
        for (Map.Entry<Student, List<Integer>> actual : classNotebook.getNotebook().entrySet()) {
            assertEquals(i, actual.getKey().getId());
            i++;
        }
    }

    @Test
    void addMarkTest() {
        ClassNotebook classNotebook = new ClassNotebook();

        Student s = new Student(1, "John");
        Student s2 = new Student(3, "John");
        Student s3 = new Student(2, "John");
        classNotebook.addStudent(s);
        classNotebook.addStudent(s2);
        classNotebook.addStudent(s3);

        assertEquals(0, classNotebook.getNotebook().get(s3).size());

        classNotebook.addMark(2, 3);

        assertEquals(1, classNotebook.getNotebook().get(s3).size());
        assertEquals(3, classNotebook.getNotebook().get(s3).get(0));
    }
}