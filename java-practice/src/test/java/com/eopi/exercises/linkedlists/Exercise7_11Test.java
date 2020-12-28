package com.eopi.exercises.linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise7_11Test {

    private ListNode<Integer> createPalindromicList() {
        ListNode<Integer> tail = new ListNode<>(1, null);
        ListNode<Integer> node4 = new ListNode<>(2, tail);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        return new ListNode<>(1, node2);
    }

    private ListNode<Integer> createNonPalindromicList() {
        ListNode<Integer> tail = new ListNode<>(1, null);
        ListNode<Integer> node4 = new ListNode<>(3, tail);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        return new ListNode<>(1, node2);
    }

    @Test
    void isListPalindromic_palindromicList_returnsTrue() {
        assertThat(Exercise7_11.isListPalindromic(createPalindromicList())).isTrue();
    }

    @Test
    void isListPalindromic_nonPalindromicList_returnsFalse() {
        assertThat(Exercise7_11.isListPalindromic(createNonPalindromicList())).isFalse();
    }
}
