package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
    Software Validation and Verification
    Project is about parameterized test.
    Yunus Emre Yiğit
    B201202009
    https://github.com/yunusemreyigit/SVV_Project
 */

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @ParameterizedTest
    @CsvSource(
            {"10,2,5","10,4,2.5","12.5,2.5,5","10,2.5,4","12.5,5,2.5"}
    )
    void  parameterizedTest(float a, float b, float expected){
        assertEquals(expected,Calculator.divide(a,b));
    }
    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }
}