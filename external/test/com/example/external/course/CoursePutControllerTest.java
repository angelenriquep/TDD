package com.example.external.course;

import com.example.external.StarterTests;
import org.junit.jupiter.api.Test;



class CoursePutControllerTest extends StarterTests {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/courses/1aab45ba-3c7a-4344-8936-78466eca77fa",
                "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
                201
        );
    }
}