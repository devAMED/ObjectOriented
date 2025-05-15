package oop.q3;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public boolean removeStudent(Student s) {
        return students.remove(s);
    }

    public void printStudents() {
        for (Student s : students) {
            System.out.println(s.name + " " + s.surname);
        }
    }

    // “Me” data
    private static final Student ME =
            new Student("Muhammad", "Ahmed", "Georgia", /*info*/ null);
    private static final String PERSONAL_NUMBER = "0123456";
    private static final List<String> MY_COURSES = List.of(
            "Object-Oriented Programming",
            "Data Structures",
            "Databases",
            "Operating Systems"
    );

    /**
     *If s matches ME and ME is enrolled  return course list.
     *If s matches ME but not enrolled     return personal number.
     *Otherwise, if s is enrolled     return s.info.
     *    Else     return null.
     */
    public String getStudentInfoStrange(Student s) {
        if (s.equals(ME)) {
            return students.contains(ME)
                    ? String.join(", ", MY_COURSES)
                    : PERSONAL_NUMBER;
        }
        return students.contains(s) ? s.info : null;
    }
}
