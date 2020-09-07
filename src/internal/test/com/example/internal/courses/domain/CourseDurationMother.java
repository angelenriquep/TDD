package com.example.internal.courses.domain;

import com.example.shared.domain.IntegerMother;
import com.example.shared.domain.RandomElementPicker;

public final class CourseDurationMother {
    public static CourseDuration create(String value) {
        return new CourseDuration(value);
    }

    public static CourseDuration random() {
        return create(
            String.format(
                "%s %s",
                IntegerMother.random(),
                RandomElementPicker.from("months", "years", "days", "hours", "minutes", "seconds")
            )
        );
    }
}
