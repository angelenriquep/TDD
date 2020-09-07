package com.example.internal.courses.infrastructure;

import com.example.internal.courses.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

final class InMemoryCourseRepositoryImplTest {

    //Integration test,
    // we do not mock anything, its a real test
    @Test
    void create_a_calid_course() {
        InMemoryCourseRepositoryImpl repository = new InMemoryCourseRepositoryImpl();
        // creamos un random para cambiar la implementacion de los datos,
        // asi no tenemos que cambiar todo
        Course course = CourseMother.random();

        repository.save(course);
    }

    @Test
    void return_an_existing_course() {
        InMemoryCourseRepositoryImpl repository = new InMemoryCourseRepositoryImpl();
        Course course = CourseMother.random();

        repository.save(course);

        // Ahora si, an optional. Actual course 2nd parameter
        assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        // Always create the instance we are testing
        InMemoryCourseRepositoryImpl repository = new InMemoryCourseRepositoryImpl();

        // We ensure that this optional is going to asnwer NO, I have not
        assertFalse(repository.search(CourseIdMother.random()).isPresent());
    }



}