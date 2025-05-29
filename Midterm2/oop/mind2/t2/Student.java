package oop.mind2.t2;

import java.util.List;

/**
 * Represents a student with an ID, name, and a list of courses.
 */
public class Student {
    private String id;
    private String name;
    private List<LearningCourse> courses;

    // Constructors
    public Student() { }
    public Student(String id, String name, List<LearningCourse> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    // Getters & setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<LearningCourse> getCourses() {
        return courses;
    }
    public void setCourses(List<LearningCourse> courses) {
        this.courses = courses;
    }
}
