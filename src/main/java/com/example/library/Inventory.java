package main.java.com.example.library;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to manage Books.
 * It has Map of Books by isbn and count.
*/
public class Inventory {
    // Map of ISBN -> Book object
    private Map<String, Book> bookMap;
    // Map of ISBN -> number of copies
    private Map<String, Integer> bookCount;

    // Constructor
    public Inventory() {
        this.bookMap = new HashMap<>();
        this.bookCount = new HashMap<>();
    }

    /**
     * Add a book to the inventory.
     * If the book already exists (by ISBN), increase its count.
     * Otherwise, create a new entry in bookMap and bookCount.
     */
    public void addBook(String title, String author, String isbn, int year, int copies) {
        Book existing = getBook(isbn);
        if (existing != null) {
            // Increase count if book already exists
            int current = bookCount.getOrDefault(isbn, 0);
            bookCount.put(isbn, current + copies);
        } else {
            // Create new book
            Book book = new Book(title, author, isbn, year);
            bookMap.put(isbn, book);
            bookCount.put(isbn, copies);
        }
    }


    /**
     * Get a book by ISBN.
     * @param isbn ISBN of the book
     * @return Book if found, else null
     */
    public Book getBook(String isbn) {
        return bookMap.getOrDefault(isbn, null);
    }

    /**
     * Get number of copies of a book by ISBN.
     * @param isbn ISBN of the book
     * @return count of copies, 0 if not found
     */
    public int getBookCount(String isbn) {
        return bookCount.getOrDefault(isbn, 0);
    }

    /**
     * Remove a book completely from inventory.
     * Both the book object and its count are removed.
     */
    public void removeBook(String isbn) {
        bookMap.remove(isbn);
        bookCount.remove(isbn);
    }

    /**
     * Update book details (title, author, year).
     * Count stays as it is unless modified separately.
     */
    public void updateBook(String isbn, String newTitle, String newAuthor, int newYear) {
        Book book = getBook(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPublicationYear(newYear);
        }
    }

    /**
     * Update the number of copies of an existing book.
     */
    public void updateBookCount(String isbn, int newCount) {
        if (bookCount.containsKey(isbn)) {
            bookCount.put(isbn, newCount);
        }
    }

    /**
     * Get all books as a map.
     * Used for searching.
     */
    public Map<String, Book> getAllBooks() {
        return bookMap;
    }
}
