package com.eopi.exercises.linkedlists;

/**
 * A node of a singly-linked list
 */
public class ListNode<T> {
	public T data;
	public ListNode<T> next;

	public ListNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String retVal = "ListNode{" +
				"data=" + data +
				", next=";
		if (next == null) {
			retVal += "null";
		} else {
			retVal += next.data;
		}
		retVal += '}';
		return retVal;
	}
}
