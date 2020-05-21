package main

import (
	"fmt"
	"strings"
)

func main() {
	listNode := createListNodeFromIntArray([]int{1, 2, 3, 4, 5})
	print(listNode.String())
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l ListNode) String() string {
	var sb strings.Builder
	sb.WriteString(fmt.Sprintf("%d", l.Val))
	i := l
	for i.Next != nil {
		i = *i.Next
		sb.WriteString(fmt.Sprintf(" -> %d", i.Val))
	}
	return sb.String()
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	i := l1
	j := l2
	carry := 0

	head := &ListNode{
		Val:  0,
		Next: nil,
	}
	sum := head

	for i != nil || j != nil {
		sum.Val += carry
		if i != nil {
			sum.Val += i.Val
			i = i.Next
		}
		if j != nil {
			sum.Val += j.Val
			j = j.Next
		}
		carry = sum.Val / 10
		sum.Val = sum.Val % 10

		if i != nil || j != nil {
			sum.Next = &ListNode{
				Val:  0,
				Next: nil,
			}
			sum = sum.Next
		} else if carry > 0 {
			sum.Next = &ListNode{
				Val:  carry,
				Next: nil,
			}
			sum = sum.Next
		}
	}

	return head
}

func createListNodeFromIntArray(source []int) *ListNode {
	head := &ListNode{
		Val:  0,
		Next: nil,
	}
	cursor := head

	for i := 0; i < len(source); i++ {
		cursor.Val = source[i]
		if i != len(source) - 1 {
			cursor.Next = &ListNode{
				Val:  0,
				Next: nil,
			}
			cursor = cursor.Next
		}
	}
	return head
}

//func createListNodeFromInt(intVal int64) *ListNode {
//	head := &ListNode{
//		Val:  0,
//		Next: nil,
//	}
//	cursor := head
//	for intVal > 0 {
//		cursor.Val = intVal % 10
//		intVal /= 10
//		if intVal > 0 {
//			cursor.Next = &ListNode{
//				Val:  0,
//				Next: nil,
//			}
//			cursor = cursor.Next
//		}
//	}
//	return head
//}
