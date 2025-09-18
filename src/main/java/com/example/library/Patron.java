package main.java.com.example.library;

public class Patron {
    private int id;          // Unique identifier for the patron
    private String name;     // Patron's name
    private String address;  // Patron's address

    /**
     * @brief constructor
     * @param id
     * @param name
     * @param address
     */
    public Patron(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * Get the patron's unique ID.
     * @return id of the patron
     */
    public int getId() {
        return id;
    }

    /**
     * Get the patron's name.
     * @return name of the patron
     */
    public String getName() {
        return name;
    }

    /**
     * Get the patron's address.
     * @return address of the patron
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set or update the patron's ID.
     * @param id new id value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set or update the patron's name.
     * @param name new name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set or update the patron's address.
     * @param address new address value
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Display patron details in a readable format.
     */
    public void displayDetails() {
        System.out.println("Patron ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}

