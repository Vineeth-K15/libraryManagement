package main.java.com.example.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class LendingService {
    
    private List<Lending> lendingList;
    private Inventory inventory;

    public LendingService(Inventory inventory){
        lendingList = new ArrayList<>();
        this.inventory = inventory;
    }

  /**
     * Checkout books if all are available.
     * @return Lending object on success, null on failure.
     */
    public Lending checkOutBooks(Integer patronId, List<Book> booksToCheckout) {
        // Step 1: Check availability
        for (Book book : booksToCheckout) {
            int count = inventory.getBookCount(book.getIsbn());
            if (count <= 0) {
                System.out.println("Book not available: " + book.getTitle());
                return null;
            }
        }

        // Step 2: Decrease inventory count
        for (Book book : booksToCheckout) {
            String isbn = book.getIsbn();
            int count = inventory.getBookCount(isbn);
            inventory.updateBookCount(isbn, count - 1);
        }

        // Step 3: Create and record lending
        Lending lending = new Lending(patronId, booksToCheckout, LocalDate.now());
        lendingList.add(lending);
        System.out.println("Checkout successful for patron ID " + patronId);
        return lending;
    }

    /**
     * Check in books (return).
     * @return true if return was successful, false otherwise.
     */
    public boolean checkInBooks(Integer patronId, List<Book> booksToReturn) {
        for (Lending lending : lendingList) {
            if (lending.getPatronId().equals(patronId) && !lending.isReturned()) {
                List<Book> borrowedBooks = lending.getBookList();
                boolean allBooksMatch = borrowedBooks.containsAll(booksToReturn);

                if (allBooksMatch) {
                    // Step 1: Update inventory count
                    for (Book book : booksToReturn) {
                        String isbn = book.getIsbn();
                        int count = inventory.getBookCount(isbn);
                        inventory.updateBookCount(isbn, count + 1);
                    }

                    // Step 2: Mark lending as returned
                    lending.markReturned(LocalDate.now());
                    System.out.println("Books returned for patron ID " + patronId);
                    return true;
                }
            }
        }
        System.out.println("No active lending found for patron ID " + patronId);
        return false;
    }

    public List<Book> getBorrowingHistory(Integer patronId) {
        List<Book> history = new ArrayList<>();
        for (Lending lending : lendingList) {
            if (lending.getPatronId().equals(patronId)) {
                history.addAll(lending.getBookList());
            }
        }
        return history;
    }

}
