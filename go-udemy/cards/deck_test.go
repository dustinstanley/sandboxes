package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestNewDeck(t *testing.T) {
	d := newDeck()

	assert.Equal(t, 16, len(d), "Expected deck length of 16, but got %v", len(d))
}
