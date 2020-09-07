package com.example.internal.courses.application;

import com.example.internal.courses.domain.Course;

import java.util.Objects;

public class CourseRequest {
    private final String id;
    private final String name;
    private final String duration;

    public CourseRequest(String id, String name, String duration) {
        this.id         = id;
        this.name       = name;
        this.duration   = duration;
    }

    public String id() { return id; }
    public String name() { return name; }
    public String duration() { return duration; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id()) &&
                Objects.equals(name, course.name()) &&
                Objects.equals(duration, course.duration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}

