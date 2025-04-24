package t3;

import java.util.*;

public class LMS {

    /* data classes */
    static class Student {
        final int id; final String name;
        Student(int id, String name){ this.id=id; this.name=name; }
        public String toString(){ return id+" – "+name; }
    }

    static class Course {
        final String code, title; final int capacity;
        final List<Student> roster = new ArrayList<>();
        Course(String code,String title,int capacity){
            this.code=code; this.title=title; this.capacity=capacity;
        }
        boolean enrol(Student s){
            if(roster.size()>=capacity || roster.contains(s)) return false;
            roster.add(s); return true;
        }
        public String toString(){ return code+" (“"+title+"”) ["+roster.size()+"/"+capacity+"]"; }
    }

    /* ===== NEW FEATURE: GradeBook ===================================== */
    static class GradeBook {
        private static final Map<String,Integer> map = new HashMap<>();
        static void addGrade(Course c, Student s, int mark){
            map.put(key(c,s), mark);
        }
        static void report(Course c){
            System.out.println("── Grade report for "+c.code+" ──");
            double sum=0; int n=0;
            for(Student s: c.roster){
                Integer g = map.get(key(c,s));
                if(g!=null){ System.out.printf("%-20s %3d%n",s.name,g); sum+=g; n++; }
            }
            if(n>0) System.out.printf("Average: %.1f%n", sum/n);
        }
        private static String key(Course c, Student s){ return c.code+"#"+s.id; }
    }
    /* ================================================================== */

    static final Map<Integer,Student> students = new HashMap<>();
    static final Map<String ,Course > courses  = new HashMap<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        menu();
    }

    private static void menu(){
        while(true){
            System.out.println("""
                \n=== LMS MENU ===
                1. List courses
                2. Register student
                3. Enrol student
                4. Add grade
                5. Show grades
                0. Exit""");
            switch(in.nextLine()){
                case "1"-> courses.values().forEach(System.out::println);
                case "2"-> registerStudent();
                case "3"-> enrolStudent();
                case "4"-> addGrade();
                case "5"-> GradeBook.report(pickCourse());
                case "0"-> System.exit(0);
                default -> System.out.println("Bad choice");
            }
        }
    }

    private static void registerStudent(){
        System.out.print("Name? "); String name = in.nextLine();
        int id = students.keySet().stream().mapToInt(i->i).max().orElse(0)+1;
        students.put(id,new Student(id,name));
        System.out.println("Registered "+name+" with ID "+id);
    }

    private static void enrolStudent(){
        Student s = pickStudent(); if(s==null) return;
        Course  c = pickCourse();  if(c==null) return;
        System.out.println(c.enrol(s)? "Enrolled ✔" : "Could not enrol");
    }

    private static void addGrade(){
        Student s = pickStudent(); if(s==null) return;
        Course  c = pickCourse();  if(c==null) return;
        if(!c.roster.contains(s)){ System.out.println("Student not enrolled"); return;}
        System.out.print("Grade? "); int g=Integer.parseInt(in.nextLine());
        GradeBook.addGrade(c,s,g);
    }

    private static Student pickStudent(){
        students.values().forEach(System.out::println);
        System.out.print("Student ID? ");
        return students.getOrDefault(Integer.parseInt(in.nextLine()), null);
    }
    private static Course pickCourse(){
        courses.values().forEach(System.out::println);
        System.out.print("Course code? ");
        return courses.getOrDefault(in.nextLine().trim().toUpperCase(), null);
    }

    private static void seedData(){
        courses.put("CS101", new Course("CS101","Intro to CS",3));
        courses.put("MATH1", new Course("MATH1","Calculus I",2));
        students.put(1,new Student(1,"Alice"));
        students.put(2,new Student(2,"Bob"));
    }
}
