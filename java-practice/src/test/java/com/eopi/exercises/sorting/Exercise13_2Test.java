package com.eopi.exercises.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise13_2Test {

    @Test
    void mergeSortedArrays_withSampleSet_isOk() {
        Integer[] firstArray = new Integer[] {5, 13, 17, null, null, null, null, null};
        Integer[] secondArray = new Integer[] {3, 7, 11, 19};
        Integer[] expected = new Integer[] {3, 5, 7, 11, 13, 17, 19, null};

        assertThat(Exercise13_2.mergeSortedArrays(firstArray, secondArray)).containsExactly(expected);
    }
}
