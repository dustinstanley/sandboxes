package com.eopi.exercises.bst;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.eopi.exercises.binarytrees.BinaryTreeNode;
import com.eopi.exercises.binarytrees.BinaryTreeUtil;

class Exercise14_2Test {

    static Object[][] nextLargestKeyProvider() {
        BinaryTreeNode<Integer> bst = BinaryTreeUtil.createExampleBST();
        return new Object[][] {
                {bst, 23, 29},
                {bst, 31, 37},
                {bst, 5, 7},
                {bst, 13, 17},
                {bst, 43, 47},
                {bst, 600, Integer.MAX_VALUE}
        };
    }

    @ParameterizedTest
    @MethodSource("nextLargestKeyProvider")
    void findNextLargestKey_isOk(BinaryTreeNode<Integer> root, Integer key, Integer expected) {
        assertThat(Exercise14_2.findNextLargestKey(root, key)).isEqualTo(expected);
    }

}
