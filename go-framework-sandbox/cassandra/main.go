package main

import(
	"github.com/gocql/gocql"
)

func main() {
	cluster := gocql.NewCluster("192.168.1.1")
	cluster.Keyspace = "example"

	session, _ := cluster.CreateSession()

	session.Query("use example2")
}