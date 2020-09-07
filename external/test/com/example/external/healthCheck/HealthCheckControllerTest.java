package com.example.external.healthCheck;

import com.example.external.StarterTests;
import org.junit.jupiter.api.Test;

// No compratimos comportamiento medienta composicion
// Heredamos
final class HealthCheckControllerTest extends StarterTests {
    @Test
    void healthCheckIsWorkingHappyCase() throws  Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }

}