package com.eopi.exercises.searching;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise11_8Test {

    static Object[][] testProvider() {
        List<Integer> sourceArray = newArrayList(3, 2, 1, 5, 4);
        return new Object[][] {
                {sourceArray, 1, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("testProvider")
    void findKthLargestElement_isOk(List<Integer> A, int k, int expected) {
        assertThat(Exercise11_8.findKthLargestElement(A, k)).isEqualTo(expected);
    }
}
