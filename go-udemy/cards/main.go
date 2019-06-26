package main

import "fmt"

func main() {
	deck := newDeckFromFile("my_cards")
	fmt.Print("Deck: ", deck.toString())
}

func newCard() string {
	return "Five of Diamonds"
}
