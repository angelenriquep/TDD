package com.example.internal.courses.infrastructure;

import com.example.internal.courses.domain.Course;
import com.example.internal.courses.domain.CourseId;
import com.example.internal.courses.domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;

//@Service lo quitamos para implmentar el de la bbdd
public final class InMemoryCourseRepositoryImpl implements CourseRepository {

    private HashMap<String, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        this.courses.put(course.id().value(), course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id.value()));
    }
}
