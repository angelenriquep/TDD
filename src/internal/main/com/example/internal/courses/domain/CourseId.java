package com.example.internal.courses.domain;

import com.example.shared.domain.Identifier;


public final class CourseId extends Identifier {
    public CourseId(String value) {
        super(value);
    }

    private CourseId() {
        super(null);
    }
}
