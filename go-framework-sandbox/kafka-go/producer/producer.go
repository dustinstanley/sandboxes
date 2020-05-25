package main

import (
	"context"
	"fmt"
	"github.com/segmentio/kafka-go"
	"net/http"
	_ "net/http"
	"time"
)

func main() {
	http.HandleFunc("/message", handleMessage)

	_ = http.ListenAndServe(":8080", nil)
}

func handleMessage(w http.ResponseWriter, req *http.Request) {
	for name, headers := range req.Header {
		for _, h := range headers {
			_, _ = fmt.Fprintf(w, "%v: %v\n", name, h)
		}
	}

	kw := kafka.NewWriter(kafka.WriterConfig{
		Brokers:           []string{"localhost:9092"},
		Topic:             "Topic1",
		Balancer:          &kafka.LeastBytes{},
		MaxAttempts:       0,
		QueueCapacity:     0,
		BatchSize:         0,
		BatchBytes:        0,
		BatchTimeout:      0,
		ReadTimeout:       0,
		WriteTimeout:      0,
		RebalanceInterval: 0,
		IdleConnTimeout:   0,
		RequiredAcks:      0,
		Async:             false,
	})

	msg := kafka.Message{
		Topic:     "Topic1",
		Partition: 0,
		Offset:    0,
		Key:       []byte("http_message_key"),
		Value:     []byte("message_received"),
		Headers:   nil,
		Time:      time.Time{},
	}
	_ = kw.WriteMessages(context.Background(), msg)
}

//func main() {
//	r := kafka.NewReader(kafka.ReaderConfig{
//		Brokers:   []string{"localhost:9092"},
//		Topic:     "Topic1",
//		Partition: 0,
//		MinBytes:  10e3,
//		MaxBytes:  10e6,
//	})
//	_ = r.SetOffset(0)
//
//	for {
//		m, err := r.ReadMessage(context.Background())
//		if err != nil {
//			break
//		}
//		fmt.Printf("message at offset %d: %s = %s\n", m.Offset, string(m.Key), string(m.Value))
//	}
//
//	_ = r.Close()
//}
