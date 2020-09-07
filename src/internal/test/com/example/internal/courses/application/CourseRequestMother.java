package com.example.internal.courses.application;

import com.example.internal.courses.domain.*;

public final class CourseRequestMother {
    public static CourseRequest create(CourseId id, CourseName name, CourseDuration duration) {
        return new CourseRequest(id.value(), name.value(), duration.value());
    }

    public static CourseRequest random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }
}
