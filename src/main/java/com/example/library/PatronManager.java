package main.java.com.example.library;

import java.util.HashMap;
import java.util.Map;

public class PatronManager {
    private Map<Integer, Patron> patrons;

    public PatronManager() {
        this.patrons = new HashMap<>();
    }

    public void registerNewPatron(int id, String name, String address) {
        Patron patron = new Patron(id, name, address);
        addPatron(patron);
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public Patron getPatron(int id) {
        return patrons.get(id);
    }

    public void updatePatron(int id, String name, String address) {
        Patron patron = patrons.get(id);
        if (patron != null) {
            patron.setName(name);
            patron.setAddress(address);
        }
    }

    public void removePatron(int id) {
        patrons.remove(id);
    }

    public Map<Integer, Patron> getAllPatrons() {
        return patrons;
    }
}

