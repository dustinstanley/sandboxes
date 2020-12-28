package com.eopi.exercises.searching;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Exercise11_1Test {

    @Test
    void findFirstOccurrence_allEntriesEqual_returnsElementAtFirstIndex() {
        List<Integer> arrayWithSameElements = Arrays.asList(5, 5, 5, 5, 5);

        assertThat(Exercise11_1.findFirstOccurrence(arrayWithSameElements, 5)).isZero();
    }

    static Object[][] arrayWithRepeatedElements() {
        List<Integer> arrayWithRepeatedElements = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
        return new Object[][] {
                {arrayWithRepeatedElements, 108, 3},
                {arrayWithRepeatedElements, 285, 6},
                {arrayWithRepeatedElements, 2, 2},
                {arrayWithRepeatedElements, -14, 0},
                {arrayWithRepeatedElements, 401, 9}
        };
    }

    @ParameterizedTest
    @MethodSource("arrayWithRepeatedElements")
    void findFirstOccurrence_arrayWithRepeatedElements_isOk(List<Integer> itemsToSearch, int valueToSearch,
            int expectedIndex) {

        assertThat(Exercise11_1.findFirstOccurrence(itemsToSearch, valueToSearch)).isEqualTo(expectedIndex);
    }
}
