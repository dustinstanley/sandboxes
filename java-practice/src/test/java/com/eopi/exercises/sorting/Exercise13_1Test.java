package com.eopi.exercises.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise13_1Test {

    @Test
    void computeIntersection_withSampleSet_isOk() {
        Integer[] arrayOne = new Integer[] {2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
        Integer[] arrayTwo = new Integer[] {5, 5, 6, 8, 8, 9, 10, 10};

        Integer[] result = Exercise13_1.computeIntersection(arrayOne, arrayTwo);

        assertThat(result).containsExactly(5, 6, 8);
    }
}
