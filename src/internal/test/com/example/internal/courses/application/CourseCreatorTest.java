package com.example.internal.courses.application;


import com.example.internal.courses.domain.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

final class CourseCreatorTest {

    @Test
    void create_a_valid_course() {
        // No podemos hacer un assert
        // La ausencia de excepciones es que tutto ha ido bien
        // Solo validamos que estamos llamando a la interface.
        // Ojo porque esto es un spy en mockito
        CourseRepository    repository  = mock(CourseRepository.class);
        CourseCreator       creator     = new CourseCreator(repository);

        CourseRequest request = new CourseRequest("decf33ca-81a7-419f-a07a-74f214e928e5", "some-name", "some-duration");

        Course course = new Course(
                new CourseId(request.id()),
                new CourseName(request.name()),
                new CourseDuration(request.duration())
                );

        creator.create(request);

        verify(repository, atLeastOnce()).save(course);
    }
}