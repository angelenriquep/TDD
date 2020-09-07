package com.example.internal.courses.domain;

import com.example.internal.courses.application.CourseRequest;

public final class CourseMother {
    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        return new Course(id, name, duration);
    }

    public static Course fromRequest(CourseRequest request) {
        return create(
                CourseIdMother.create(request.id()),
                CourseNameMother.create(request.name()),
                CourseDurationMother.create(request.duration())
        );
    }

    public static Course random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
