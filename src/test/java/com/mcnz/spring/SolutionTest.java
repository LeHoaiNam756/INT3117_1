package com.mcnz.spring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

class SolutionTest {
    static Stream<Arguments> whoWinTestCases() {
        return Stream.of(
            Arguments.of(0.0, 7.5, 50.0, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(0.1, 7.5, 50.0, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(99.9, 7.5, 50.0, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(100.0, 7.5, 50.0, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 0.0, 50.0, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 0.1, 50.0, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 14.9, 50.0, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 15.0, 50.0, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 7.5, 0.0, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 7.5, 0.1, 7.5, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 7.5, 99.9, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 7.5, 100.0, 7.5, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 7.5, 50.0, 0.0, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 7.5, 50.0, 0.1, 25.0, 10.0, "Tom"),
            Arguments.of(50.0, 7.5, 50.0, 14.9, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 7.5, 50.0, 15.0, 25.0, 10.0, "Butch"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 0.0, 10.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 0.1, 10.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 49.9, 10.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 50.0, 10.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 25.0, 0.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 25.0, 0.1, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 25.0, 19.9, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 25.0, 20.0, "Jerry"),
            Arguments.of(50.0, 7.5, 50.0, 7.5, 25.0, 10.0, "Jerry"),
            Arguments.of(10.0, 5.0, 20.0, 4.0, 30.0, 6.0, "Tom"), // Kiểm thử dòng điểu khiển
            Arguments.of(8.0, 2.0, 12.0, 3.0, 10.0, 3.0, "Butch"),
            Arguments.of(10.0, 4.0, 10.0, 4.0, 15.0, 2.0, "Jerry"),
            Arguments.of(10.0, 8.0, 80.0, 4.0, 15.0, 6.0, "Tom"),
            Arguments.of(100.0, 2.0, 10.0, 8.0, 5.0, 3.0, "Butch"),
            Arguments.of(100.0, 2.0, 80.0, 2.0, 2.0, 3.0, "Jerry"),
            Arguments.of(10.0, 2.0, 20.0, 2.0, 30.0, 10.0, "Jerry")
        );
    }

    @ParameterizedTest
    @MethodSource("whoWinTestCases")
    void testWhoWin(double x1, double v1, double x2, double v2, double x3, double v3, String expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.whoWin(x1, v1, x2, v2, x3, v3));
    }
}
