package add_two_numbers

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
		// TODO: Add test cases.
		{
			name: "simple case",
			args: args{
				l1: create_listNode(12345),
				l2: create_listNode(12345),
			},
			want: create_listNode(24690),
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := add_two_numbers(tt.args.l1, tt.args.l2); !reflect.DeepEqual(got, tt.want) {
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