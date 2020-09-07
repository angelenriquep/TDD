package com.example.internal.courses.domain;

import com.example.shared.domain.StringValueObject;

public final class CourseName extends StringValueObject {
    public CourseName(String value) {
        super(value);
    }

    // No queda mas remedio que ahcerlo por el hibernate
    // UN ORM no esta condicionando, constructor vacio.
    private CourseName() {
        super(null);
    }
}
