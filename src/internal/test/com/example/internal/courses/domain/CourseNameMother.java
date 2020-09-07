package com.example.internal.courses.domain;

import com.example.shared.domain.WordMother;

public final class CourseNameMother {
    // Esto es una facotira, me ayuda a crear objectos
    public static CourseName create(String value) { return new CourseName(value); }

    public static CourseName random() {
        return create(WordMother.random());
    }

}