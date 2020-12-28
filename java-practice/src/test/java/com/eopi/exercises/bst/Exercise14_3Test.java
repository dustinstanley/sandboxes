package com.eopi.exercises.bst;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.eopi.exercises.binarytrees.BinaryTreeUtil;

class Exercise14_3Test {

    static Object[][] findLargestProvider() {
        return new Object[][] {
                {5, Arrays.asList(53, 47, 43, 41, 37)},
                {12, Arrays.asList(53, 47, 43, 41, 37, 31, 29, 23, 19, 17, 13, 11)}
        };
    }

    @ParameterizedTest
    @MethodSource("findLargestProvider")
    void findLargestNodes_isOk(int k, List<Integer> expected) {
        List<Integer> largestFiveIntegers = Exercise14_3.findLargestNodes(BinaryTreeUtil.createExampleBST(), k);

        assertThat(largestFiveIntegers).containsExactlyElementsOf(expected);
    }
}
