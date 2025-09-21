package main.java.com.example.library;

import java.util.ArrayList;
import java.util.List;
public class LendingService {
    
    private List<Lending> lendingList;

    public LendingService(){
        lendingList = new ArrayList<>();
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
