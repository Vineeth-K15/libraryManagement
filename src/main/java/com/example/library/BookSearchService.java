package main.java.com.example.library;



import java.util.ArrayList;
import java.util.List;

public class BookSearchService {

    private Inventory inventory;

    // Inject Inventory dependency
    public BookSearchService(Inventory inventory) {
        this.inventory = inventory;
    }

    // Setter injection to allow swapping inventory
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    /**
     * Search books by title (case-insensitive).
     */
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory.getAllBooks().values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Search books by author (case-insensitive).
     */
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory.getAllBooks().values()) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Search book by ISBN (exact match).
     */
    public Book searchByIsbn(String isbn) {
        return inventory.getBook(isbn); // already implemented in Inventory
    }
}

