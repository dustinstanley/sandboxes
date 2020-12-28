package com.eopi.exercises.primitivetypes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise4_1Test {

    private final Exercise4_1 ref = new Exercise4_1();

    static Object[][] longDataProvider() {
        return new Object[][]{
                {Long.MAX_VALUE},
                {Long.MIN_VALUE},
                {-124124L},
                {1423235423L},
                {4353L},
                {0}
        };
    }

    @ParameterizedTest
    @MethodSource("longDataProvider")
    void computeParityOfWord_givenWord_isOk(long word) {
        System.out.println(word + " long binary: " + Long.toBinaryString(word) + " bit count: " + Long.bitCount(word));
        assertThat(ref.computeParityOfWord(word)).isEqualTo((short)(Long.bitCount(word) % 2));
    }
}
