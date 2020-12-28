package com.eopi.exercises.heaps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Exercise10_1Test {

    @Test
    void computeUnion_isOk() {
        List<Integer> result = Exercise10_1.computeUnion(
                Arrays.asList(Arrays.asList(3, 5, 7), Arrays.asList(0, 6), Arrays.asList(0, 6, 28)));
        assertThat(result).containsExactly(0, 0, 3, 5, 6, 6, 7, 28);
    }
}
