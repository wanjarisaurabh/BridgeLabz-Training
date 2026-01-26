package com.junit.exceptionhandling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    private final MathUtils utils = new MathUtils();

    @Test
    void testDivideThrowsException() {
        assertThrows(ArithmeticException.class, () -> utils.divide(10, 0));
    }
}