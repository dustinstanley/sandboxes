package com.eopi.exercises.bst;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.eopi.exercises.binarytrees.BinaryTreeNode;
import com.eopi.exercises.binarytrees.BinaryTreeUtil;

class Exercise14_10Test {

    static Object[][] insertionDataProvider() {
        return new Object[][]{
                {BinaryTreeUtil.createExampleBST(), 10,
                        Arrays.asList(2, 3, 5, 7, 10, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 11,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {new BinaryTreeNode<>(5, "root"), 6, Arrays.asList(5, 6)},
                {null, 6, Collections.singletonList(6)}
        };
    }

    static Object[][] deletionDataProvider() {
        return new Object[][]{
                {BinaryTreeUtil.createExampleBST(), 19,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 11,
                        Arrays.asList(2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 13,
                        Arrays.asList(2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 37,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 17,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 19, 23, 29, 31, 37, 41, 43, 47, 53)}
        };
    }

    @ParameterizedTest
    @MethodSource("insertionDataProvider")
    void insert_isOk(BinaryTreeNode<Integer> root, int keyToInsert, List<Integer> expected) {
        BinarySearchTree tree = new BinarySearchTree(root);

        tree.insert(keyToInsert);

        assertThat(Exercise14_1.isBST(tree.root)).isTrue();
        assertThat(BinaryTreeUtil.inorderTraversalReturningTraversedKeys(tree.root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("deletionDataProvider")
    void delete_isOk(BinaryTreeNode<Integer> root, int keyToDelete, List<Integer> expected) {
        BinarySearchTree tree = new BinarySearchTree(root);

        tree.delete(keyToDelete);

        assertThat(Exercise14_1.isBST(tree.root)).isTrue();
        assertThat(BinaryTreeUtil.inorderTraversalReturningTraversedKeys(tree.root)).isEqualTo(expected);
    }
}
