package com.eopi.exercises.linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListUtil {

    public static ListNode<Integer> createSequentialList() {
        return createLinkedList(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    static ListNode<Integer> createListWithCycle(int[] data, int indexOfEndOfCycle) {
        ListNode<Integer> head = createLinkedList(data);

        ListNode<Integer> cursor = head;
        ListNode<Integer> prev = cursor;
        for (int i = 0; i < indexOfEndOfCycle; i++) {
            prev = cursor;
            cursor = cursor.next;
        }

        //Create the cycle condition - end of cycle points to previous node
        cursor.next = prev;

        return head;
    }

    public static ListNode<Integer> createLinkedList(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ListNode<Integer> head = new ListNode<>(data[0]);

        ListNode<Integer> cursor = head;
        for (int i = 1; i < data.length; i++) {
            ListNode<Integer> nextNode = new ListNode<>(data[i]);
            cursor.next = nextNode;
            cursor = nextNode;
        }
        return head;
    }

    public static void verifyListResult(ListNode<Integer> listHead, int[] expected) {
        for (int expectedValue : expected) {
            assertThat(expectedValue).isEqualTo(listHead.data.intValue());
            listHead = listHead.next;
        }
        assertThat(listHead).isNull();
    }

}
