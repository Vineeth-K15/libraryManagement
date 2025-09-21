package main.java.com.example.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lending {
  
    private Integer personId;
    private List<Book> bookList;
    private LocalDate checkoutDate;
    private LocalDate returnDate;


 // Constructor WITHOUT returnDate (default = null)
    public Lending(Integer personId, List<Book> bookList, LocalDate checkoutDate) {
        this(personId, bookList, checkoutDate, null);
    }

    // Constructor WITH returnDate
    public Lending(Integer personId, List<Book> bookList, LocalDate checkoutDate, LocalDate returnDate) {
        this.personId = personId;
        this.bookList = new ArrayList<>(bookList);
        this.checkoutDate = checkoutDate;
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void markReturned(LocalDate date) {
        this.returnDate = date;
    }

    public Integer getPatronId(){
        return this.personId;
    }

    public List<Book> getBookList(){
        return this.bookList;
    }
}