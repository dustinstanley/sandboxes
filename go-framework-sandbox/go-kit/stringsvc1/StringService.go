package main

// YOUR BUSINESS LOGIC
// StringService interface provides operations on strings.
import (
	"errors"
	"strings"
)

type StringService interface {
	Uppercase(string) (string, error)
	Count(string) int
}

// Implementation of StringService
type stringService struct{}

func (stringService) Uppercase(s string) (string, error) {
	if s == "" {
		return "", ErrEmpty
	}
	return strings.ToUpper(s), nil
}

func (stringService) Count(s string) int {
	return len(s)
}

// ErrEmpty is returned when input string is empty
var ErrEmpty = errors.New("Empty string")

