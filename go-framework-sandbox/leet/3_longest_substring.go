package main

func lengthOfLongestSubstring(s string) int {
	maxLength := 0
	letters := make(map[rune]int)

	for pos, curLetter := range s {
		if letters[curLetter] != 0 {
			// TODO: calculate length of current substring by looking up position of last occurrence of this character
			// TODO: and comparing against current position
			maxLength = max(len(letters), maxLength)
			letters = make(map[rune]int)
		}
		letters[curLetter] = pos
	}

	maxLength = max(len(letters), maxLength)

	return maxLength
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}