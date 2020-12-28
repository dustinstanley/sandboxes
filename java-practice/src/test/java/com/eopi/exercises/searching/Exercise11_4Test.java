package com.eopi.exercises.searching;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise11_4Test {

    static Object[][] computeIntegerSquareRootProvider() {
        return new Object[][] {
                {16, 4},
                {300, 17},
                {4, 2},
                {1, 1},
                {0, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("computeIntegerSquareRootProvider")
    void computeIntegerSquareRoot_isOk(int k, int expected) {
        assertThat(Exercise11_4.computeIntegerSquareRoot(k)).isEqualTo(expected);
    }
}
