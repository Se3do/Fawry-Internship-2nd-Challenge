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

        for(int i = 0; i < inventory.size(); i++) {
            Book book = inventory.get(i);
            if(currentYear - book.getYear() > yearThreshold) {
                removedBooks.add(book);
                inventory.remove(i);
                System.out.println("Removed outdated book: " + book);
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        for(Book book : inventory) {
            if (book.getIsbn().equals(isbn)) {
                return book.buy(quantity, email, address);
            }
        }
        throw new IllegalArgumentException("Book with isbn(" + isbn + ") not found !!");
    }
}
