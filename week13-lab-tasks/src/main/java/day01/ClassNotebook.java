package day01;

import java.util.*;

public class ClassNotebook {

    private Map<Student, List<Integer>> notebook = new TreeMap<>();

    public Map<Student, List<Integer>> getNotebook() {
        return notebook;
    }

    public void addStudent(Student student) {
        notebook.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {

        for (Map.Entry<Student, List<Integer>> actual : notebook.entrySet()) {
            if (actual.getKey().getId() == id) {
                actual.getValue().add(mark);
            }
        }
    }
//        for (Map.Entry<Student, List<Integer>> actual : notebook.entrySet()) {
//            if (actual.getKey().getId() == id) {
//                List<Integer> result = notebook.get(actual.getKey());
//                result.add(mark);
//                notebook.put(actual.getKey(), result);
//            }
//        }
//    }

}
