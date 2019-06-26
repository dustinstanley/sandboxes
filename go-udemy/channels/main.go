package main

import (
	"fmt"
	"net/http"
	"time"
)

func main() {
	links := []string{
		"http://google.com",
		"http://facebook.com",
		"http://stackoverflow.com",
		"http://goland.org",
		"http://amazon.com",
	}

	colors := map[string]string{
		"red":   "#ff0000",
		"green": "#4bf745",
	}
	fmt.Print(colors)

	c := make(chan string)

	// For each link above, invoke the checkLink function in a separate goroutine
	for _, link := range links {
		go checkLink(link, c)
	}

	// Iterates through the link data in the channel, calling checkLink again on each link.
	// Results in an infinite loop because each time we take a link from the channel, it gets re-added again
	// with the call to checkLink.
	for l := range c {
		go func(link string) {
			time.Sleep(1 * time.Second)
			checkLink(link, c)
		}(l)
	}
}

// Checks if the link is either up or down, printing the status and then storing the link again on the given channel
func checkLink(link string, c chan string) {
	_, err := http.Get(link)
	if err != nil {
		fmt.Println(link, " might be down!")
		c <- link
		return
	}

	fmt.Println(link, " is up!")
	c <- link
}
