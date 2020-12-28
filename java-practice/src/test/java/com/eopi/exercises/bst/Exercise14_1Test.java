package com.eopi.exercises.bst;

import static com.eopi.exercises.binarytrees.BinaryTreeUtil.createExampleBST;
import static com.eopi.exercises.binarytrees.BinaryTreeUtil.createExampleUnbalancedBinaryTree;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise14_1Test {

    @Test
    void isBST_givenBST_returnsTrue() {
        assertThat(Exercise14_1.isBST(createExampleBST())).isTrue();
    }

    @Test
    void isBST_givenUnsortedTree_returnsFalse() {
        assertThat(Exercise14_1.isBST(createExampleUnbalancedBinaryTree())).isFalse();
    }

    @Test
    void isBST_BFS_givenBST_returnsTrue() {
        assertThat(Exercise14_1.isBST_BFS(createExampleBST())).isTrue();
    }

    @Test
    void isBST_BFS_givenUnsortedTree_returnsFalse() {
        assertThat(Exercise14_1.isBST_BFS(createExampleUnbalancedBinaryTree())).isFalse();
    }
}
