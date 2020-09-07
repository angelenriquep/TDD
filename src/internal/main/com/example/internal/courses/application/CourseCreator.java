package com.example.internal.courses.application;

import com.example.internal.courses.domain.*;
import com.example.shared.domain.Service;

@Service
public final class CourseCreator  {

    private final CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CourseRequest request){
        Course course = new Course(
                new CourseId(request.id()),
                new CourseName(request.name()),
                new CourseDuration(request.duration())
        );

        repository.save(course);
    }
}
