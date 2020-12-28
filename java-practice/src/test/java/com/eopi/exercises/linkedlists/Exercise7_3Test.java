package com.eopi.exercises.linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Exercise7_3Test {

    @Test
    void checkListForCycle_listWithCycle_returnsStartOfCycle() {
        ListNode<Integer> listWithCycle = LinkedListUtil.createListWithCycle(new int[] {0, 1, 2, 3, 4}, 3);
        ListNode<Integer> expectedStartOfCycle = listWithCycle;
        for (int i = 0; i < 2; i++) {
            expectedStartOfCycle = expectedStartOfCycle.next;
        }

        ListNode<Integer> actualStartOfCycle = Exercise7_3.checkListForCycle(listWithCycle);

        assertThat(actualStartOfCycle).isEqualTo(expectedStartOfCycle);
    }

    @Test
    void checkListForCycle_listWithoutCycle_returnsNull() {
        ListNode<Integer> sequentialList = LinkedListUtil.createSequentialList();

        assertThat(Exercise7_3.checkListForCycle(sequentialList)).isNull();
    }
}
