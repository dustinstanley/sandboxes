package main

func lengthOfLongestSubstring(s string) int {
	maxLength := 0
	letters := make(map[rune]int)

	for _, curLetter := range s {
		if letters[curLetter] != 0 {
			maxLength = max(letters[curLetter], maxLength)
			letters[curLetter] = 0
		} else {
			letters[curLetter] = 0
		}
		for letter, _ := range letters {
			letters[letter]++
		}
	}

	return max(maxLength, findMax(letters))
}

func findMax(letters map[rune]int) int {
	maxLength := 0

	for _, count := range letters {
		if count > maxLength {
			maxLength = count
		}
	}

	return maxLength
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}