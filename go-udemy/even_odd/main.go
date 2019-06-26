package main

import "fmt"

func main() {
	ints := []uint8{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

	for _, val := range ints {
		if val % 2 == 0 {
			fmt.Printf("\n%d is even", val)
		} else {
			fmt.Printf("\n%d is odd", val)
		}
	}
}
