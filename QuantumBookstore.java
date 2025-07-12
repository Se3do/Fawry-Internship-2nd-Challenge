import java.util.*;
import Models.Book;

public class QuantumBookstore {
    private List<Book> inventory = new ArrayList<>();

    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Added: " + book);
    }

    public List<Book> removeOutdatedBooks(int yearThreshold) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR); 
        List<Book> removedBooks = new ArrayList<>();

        Iterator<Book> iterator = inventory.iterator();
        while(iterator.hasNext()) {
            Book book = iterator.next();
            if(currentYear - book.getYear() > yearThreshold) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Removed outdated book: " + book);
            }
        }
        if(removedBooks.isEmpty()) {
            System.out.println("No outdated books found.");
        }
        else {
            System.out.println("Removed " + removedBooks.size() + " outdated books.");
        }
        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        
        for(Book book : inventory) {
            if (book.getIsbn().equals(isbn)) {
                return book.buy(quantity, email, address);
            }
        }
        throw new IllegalArgumentException("Book with isbn(" + isbn + ") not found !!");
    }
}
