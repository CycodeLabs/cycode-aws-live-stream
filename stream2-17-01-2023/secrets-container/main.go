package main

import (
	"fmt"
	"log"
	"net/http"
)

func HandleRoot(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World!")
}

var (
	AWS_ACCESS_KEY_ID     = "AKIAUDSMZPA6BXEQSCX6"
	AWS_SECRET_ACCESS_KEY = "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"
)

func main() {
	http.HandleFunc("/", HandleRoot)
	fmt.Println("Starting a simple go server on port 8080")

	if err := http.ListenAndServe(":8080", nil); err != nil {
		log.Fatal(err)
	}
}
