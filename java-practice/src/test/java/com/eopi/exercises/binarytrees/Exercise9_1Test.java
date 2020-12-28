package com.eopi.exercises.binarytrees;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise9_1Test {


    @Test
    void isHeightBalanced_unbalancedTree_returnsFalse() {
        assertThat(Exercise9_1.isHeightBalanced(BinaryTreeUtil.createExampleUnbalancedBinaryTree())).isFalse();
    }

    @Test
    void isHeightBalanced_balancedTree_returnsTrue() {
        assertThat(Exercise9_1.isHeightBalanced(BinaryTreeUtil.createExampleBalancedBinaryTree())).isTrue();
    }
}
