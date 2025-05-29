package oop.mid2.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * University Management System (UMS).
 * Holds a list of students and can print a given student's data.
 */
public class UMS {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudent(Student s) {
        students.add(s);
    }

    /**
     * Prints the student's ID, name, and all their courses
     * with full course details.
     */
    public void printStudentData(Student student) {
        System.out.println("=== Student Data ===");
        System.out.println("ID   : " + student.getId());
        System.out.println("Name : " + student.getName());
        System.out.println("\nEnrolled Courses:");
        for (LearningCourse c : student.getCourses()) {
            System.out.println(" - Title:               " + c.getTitle());
            System.out.println("   Prerequisites:       " + c.getAcceptancePrerequisites());
            System.out.println("   Major topics:        " + c.getMajorTopics());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 1) build your UMS
        UMS ums = new UMS();

        // 2) create *your* student record (hard-coded)
        Student ahmed = new Student();
        ahmed.setId("ST 1158321");
        ahmed.setName("ahmed");

        // 3) set your courses
        List<LearningCourse> myCourses = new ArrayList<>();
        myCourses.add(new LearningCourse(
                "MFOC",
                "Basic Programming",
                "Set Theory, Logic"
        ));
        myCourses.add(new LearningCourse(
                "OOP",
                "Basic Programming",
                "Classes, Objects, Inheritance"
        ));
        myCourses.add(new LearningCourse(
                "DSA",
                "Programming",
                "Arrays, Linked Lists, Trees"
        ));
        myCourses.add(new LearningCourse(
                "Calculus",
                "Pre-Calculus",
                "Limits, Derivatives, Integrals"
        ));
        ahmed.setCourses(myCourses);

        ums.addStudent(ahmed);

        // 4) print *your* data
        ums.printStudentData(ahmed);
    }
}
