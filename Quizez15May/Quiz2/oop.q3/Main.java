package oop.q3;

public class Main {
    public static void main(String[] args) {
        // University and some Student instances
        University u   = new University();
        Student   me  = new Student("Muhammad", "Ahmed",  "Georgia", "Codes Python");
        Student   bob = new Student("Bob",      "Smith",   "USA",     "Likes Java");

        // Case 2:
        System.out.println("Case B (me not enrolled): "
                + u.getStudentInfoStrange(me));

        // Case 1:
        u.addStudent(me);
        System.out.println("Case A (me enrolled): "
                + u.getStudentInfoStrange(me));

        // Case 3:
        u.addStudent(bob);
        System.out.println("Case C (other enrolled): "
                + u.getStudentInfoStrange(bob));

        // Not in university
        Student alice = new Student("Alice", "Doe", "UK", "Whatever");
        System.out.println("Case C (other not enrolled): "
                + u.getStudentInfoStrange(alice));
    }
}
