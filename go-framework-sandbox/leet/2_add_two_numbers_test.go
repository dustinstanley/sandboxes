package main

import (
	"reflect"
	"testing"
)

func Test_add_two_numbers(t *testing.T) {
	type args struct {
		l1 *ListNode
		l2 *ListNode
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			name: "simple case",
			args: args{
				l1: createListNodeFromIntArray([]int{5, 4, 3, 2, 1}),
				l2: createListNodeFromIntArray([]int{5, 4, 3, 2, 1}),
			},
			want: createListNodeFromIntArray([]int{0, 9, 6, 4, 2}),
		},
		{
			name: "simple case",
			args: args{
				l1: createListNodeFromIntArray([]int{5, 4, 3, 2, 1}),
				l2: createListNodeFromIntArray([]int{5, 4, 3}),
			},
			want: createListNodeFromIntArray([]int{0, 9, 6, 2, 1}),
		},
		{
			name: "single zero case",
			args: args{
				l1: createListNodeFromIntArray([]int{4, 5}),
				l2: createListNodeFromIntArray([]int{0}),
			},
			want: createListNodeFromIntArray([]int{4, 5}),
		},
		{
			name: "double zero case",
			args: args{
				l1: createListNodeFromIntArray([]int{0}),
				l2: createListNodeFromIntArray([]int{0}),
			},
			want: createListNodeFromIntArray([]int{0}),
		},
		{
			name: "single empty case",
			args: args{
				l1: createListNodeFromIntArray([]int{}),
				l2: createListNodeFromIntArray([]int{0}),
			},
			want: createListNodeFromIntArray([]int{0}),
		},
		{
			name: "double empty case",
			args: args{
				l1: createListNodeFromIntArray([]int{}),
				l2: createListNodeFromIntArray([]int{}),
			},
			want: createListNodeFromIntArray([]int{0}),
		},
		{
			name: "extra long value case",
			args: args{
				l1: createListNodeFromIntArray([]int{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}),
				l2: createListNodeFromIntArray([]int{5,6,4}),
			},
			want: createListNodeFromIntArray([]int{6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}),
		},
		{
			name: "carry case",
			args: args{
				l1: createListNodeFromIntArray([]int{5}),
				l2: createListNodeFromIntArray([]int{5}),
			},
			want: createListNodeFromIntArray([]int{0, 1}),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := addTwoNumbers(tt.args.l1, tt.args.l2); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("add_two_numbers() = %v, want %v", got, tt.want)
			}
		})
	}
}

//func Test_create_listNode(t *testing.T) {
//	type args struct {
//		l1 int32
//	}
//	var tests = []struct {
//		name string
//		args args
//		want *ListNode
//	}{
//		// TODO: Add test cases.
//		{
//			name: "12345",
//			args: &12345,
//			want: &ListNode{
//				Val:  0,
//				Next: nil,
//			},
//		},
//	}
//	for _, tt := range tests {
//		t.Run(tt.name, func(t *testing.T) {
//			if got := create_listNode(tt.args.l1); !reflect.DeepEqual(got, tt.want) {
//				t.Errorf("create_listNode() = %v, want %v", got, tt.want)
//			}
//		})
//	}
//}
