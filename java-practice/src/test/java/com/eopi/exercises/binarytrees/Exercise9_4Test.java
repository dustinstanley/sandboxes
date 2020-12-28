package com.eopi.exercises.binarytrees;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise9_4Test {

    private static BinaryTreeNode<Integer> rootNode = BinaryTreeUtil.createExampleUnbalancedBinaryTree();

    @Test
    void findLca_hasNonRootCommonAncestor_findsLca() {
        BinaryTreeNode<Integer> firstNode = rootNode.right.left.right.right;
        BinaryTreeNode<Integer> secondNode = rootNode.right.left.right.left.right;
        BinaryTreeNode<Integer> expectedLcaNode = rootNode.right.left.right;

        assertThat(Exercise9_4.findLca(firstNode, secondNode)).isEqualTo(expectedLcaNode);
    }

    @Test
    void findLca_hasRootCommonAncestor_findsRoot() {
        BinaryTreeNode<Integer> firstNode = rootNode.left.right.right;
        BinaryTreeNode<Integer> secondNode = rootNode.right.left.right;

        assertThat(Exercise9_4.findLca(firstNode, secondNode)).isEqualTo(rootNode);
    }

    @Test
    void findLcaEfficient_hasNonRootCommonAncestor_findsLca() {
        BinaryTreeNode<Integer> firstNode = rootNode.right.left.right.right;
        BinaryTreeNode<Integer> secondNode = rootNode.right.left.right.left.right;
        BinaryTreeNode<Integer> expectedLcaNode = rootNode.right.left.right;

        assertThat(Exercise9_4.findLca_efficient(firstNode, secondNode)).isEqualTo(expectedLcaNode);
    }

    @Test
    void findLcaEfficient_hasRootCommonAncestor_findsRoot() {
        BinaryTreeNode<Integer> firstNode = rootNode.left.right.right;
        BinaryTreeNode<Integer> secondNode = rootNode.right.left.right;

        assertThat(Exercise9_4.findLca_efficient(firstNode, secondNode)).isEqualTo(rootNode);
    }
}
