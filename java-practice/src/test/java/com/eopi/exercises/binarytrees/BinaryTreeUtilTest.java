package com.eopi.exercises.binarytrees;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinaryTreeUtilTest {

    private static BinaryTreeNode<Integer> exampleRootNode;

    @BeforeAll
    static void setUp() {
        exampleRootNode = BinaryTreeUtil.createExampleUnbalancedBinaryTree();
    }

    @Test
    void preorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.preorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    @Test
    void inorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.inorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("D", "C", "E", "B", "F", "H", "G", "A", "J", "L", "M", "K", "N", "I", "O", "P");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    @Test
    void postorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.postorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("D", "E", "C", "H", "G", "F", "B", "M", "L", "N", "K", "J", "P", "O", "I", "A");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    private void assertTraversalOrder(List<BinaryTreeNode<Integer>> actualNodes, List<String> expectedIds) {
        assertThat(actualNodes).hasSameSizeAs(expectedIds);

        for (int i = 0; i < actualNodes.size(); i++) {
            assertThat(actualNodes.get(i).id).isEqualTo(expectedIds.get(i));
        }
    }
}
