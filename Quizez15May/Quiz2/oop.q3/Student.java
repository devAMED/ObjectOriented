package oop.q3;

import java.util.Objects;

public class Student {
    public String name;
    public String surname;
    public String country;
    public String info;

    public Student(String name, String surname, String country, String info) {
        this.name    = name;
        this.surname = surname;
        this.country = country;
        this.info    = info;
    }

    // equals considers name, surname, country so two instances "match" you
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(name,    s.name) &&
                Objects.equals(surname, s.surname) &&
                Objects.equals(country, s.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, country);
    }
}
