package main.java.com.example.library;

public class Executor {

 public static void main(String[] args) {
        System.out.println("Library Management System started!");
        // Here you can create Library, Book, Patron objects and test
        Book chetan = new Book("IKIGAI", "Chingi", "111-115", 2020);
        chetan.displayBookDetails();
    }
}
