package main.java.com.example.library;

public class Library {
  private Inventory inventory;
    private BookSearchService searchService;
    private PatronManager patronManager;
    private LendingService lendingService;

    public Library() {
        this.inventory = new Inventory();
        this.patronManager = new PatronManager();
        this.searchService = new BookSearchService(inventory);
        this.lendingService = new LendingService();
    }

    public static void main(String[] args) {
        System.out.println("Library Management System started!");

        Library library = new Library();

        // Use Inventory to add book
        library.inventory.addBook("IKIGAI", "Chingi", "111-115", 2020, 3);

        // Use PatronManager to register new patron
        library.patronManager.registerNewPatron(1, "Vineeth", "Vaishnavam, Trivandrum");

    }
}
