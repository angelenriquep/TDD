package com.example.internal.courses.domain;

import com.example.shared.domain.StringValueObject;

public class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }

    private CourseDuration() {
        super(null);
    }
}
