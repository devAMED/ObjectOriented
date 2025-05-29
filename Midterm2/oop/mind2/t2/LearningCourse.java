package oop.mind2.t2;

/**
 * Represents a single course with its title, acceptance prerequisites
 * and major topics.
 */
public class LearningCourse {
    private String title;
    private String acceptancePrerequisites;
    private String majorTopics;

    // Constructors
    public LearningCourse() { }
    public LearningCourse(String title, String acceptancePrerequisites, String majorTopics) {
        this.title = title;
        this.acceptancePrerequisites = acceptancePrerequisites;
        this.majorTopics = majorTopics;
    }

    // Getters & setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAcceptancePrerequisites() {
        return acceptancePrerequisites;
    }
    public void setAcceptancePrerequisites(String acceptancePrerequisites) {
        this.acceptancePrerequisites = acceptancePrerequisites;
    }
    public String getMajorTopics() {
        return majorTopics;
    }
    public void setMajorTopics(String majorTopics) {
        this.majorTopics = majorTopics;
    }
}
