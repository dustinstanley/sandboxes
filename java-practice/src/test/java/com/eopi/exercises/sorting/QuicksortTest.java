package com.eopi.exercises.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class QuicksortTest {

    static Object[][] quicksortDataProvider() {
        return new Object[][] {
                {new int[] {5, 4, 6, 7, 9, 0, 8, 3, 1, 2}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}}
        };
    }

    @ParameterizedTest
    @MethodSource("quicksortDataProvider")
    void mergesort_isOk(int[] unsorted, int[] expected) {
        Quicksort.quicksortIntArray(unsorted, 0, unsorted.length - 1);
        assertThat(unsorted).containsExactly(expected);
    }
}
