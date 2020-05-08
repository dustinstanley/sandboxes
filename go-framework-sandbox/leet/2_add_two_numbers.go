package add_two_numbers

import (
	"fmt"
	"math"
	"strings"
)

func main() {
	listNode := create_listNode(12345)
	print(listNode)
}

type ListNode struct {
	Val int
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

func add_two_numbers(l1 *ListNode, l2 *ListNode) *ListNode {
	i := l1
	j := l2
	magnitude := 0
	sum := 0

	for i != nil && j != nil {
		sum += (i.Val + j.Val) * int(math.Pow(10, float64(magnitude)))
		magnitude++
		i = i.Next
		j = j.Next
	}

	return create_listNode(sum)
}

func create_listNode(sum int) *ListNode {
	head := &ListNode{
		Val:  0,
		Next: nil,
	}
	cursor := head
	for sum > 0 {
		cursor.Val = sum % 10
		sum /= 10
		if sum > 0 {
			cursor.Next = &ListNode{
				Val:  0,
				Next: nil,
			}
			cursor = cursor.Next
		}
	}
	return head
}