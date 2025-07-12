import Models.EBook;
import Models.PaperBook;
import Models.ShowcaseBook;

public class QuantumBookstoreTests {
    public static void main(String[] args) {
        QuantumBookstore bookstore = new QuantumBookstore();
        
        bookstore.addBook(new EBook("302", "EBook1", 2010, 10, "Mohammed Said", "pdf"));
        bookstore.addBook(new PaperBook("104", "PaperBook1", 2000, 50, "Author1", 9));
        bookstore.addBook(new ShowcaseBook("572", "ShowcaseBook1", 2025, 0, "Author2"));

        System.out.println("\n---- Buying Ebook ----");
        try {
            double paidAmount = bookstore.buyBook("302", 1, "Mohamedsaid6715@gmail.com", "Addressline");
            System.out.println("Transaction successful. Amount paid: $" + paidAmount);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n---- Buying Paperbook ----");
        try {
            double paidAmount = bookstore.buyBook("104", 9, "customer@gmail.com", "123 Main St");
            System.out.println("Transaction successful. Amount paid: $" + paidAmount);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n---- Removing Outdated Books ----");
        bookstore.removeOutdatedBooks(10);

        System.out.println("\n---- Buying Showcasebook (should fail) ----");
        try {
            double paidAmount = bookstore.buyBook("572", 1, "customer@gmail.com", "123 Main St");
            System.out.println("Transaction successful. Amount paid: $" + paidAmount);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n---- Buying Non-existent Book (should fail) ----");
        try {
            double paidAmount = bookstore.buyBook("999", 1, "customer@gmail.com", "123 Main St");
            System.out.println("Transaction successful. Amount paid: $" + paidAmount);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n---- Buying Ebook with Invalid Quantity (should fail) ----");
        try {
            double paidAmount = bookstore.buyBook("302", 2, "customer@gmail.com", "123 Main St");
            System.out.println("Transaction successful. Amount paid: $" + paidAmount);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n---- Testing Input Validation ----");
        try {
            bookstore.buyBook(null, 1, "email@test.com", "address");
        } catch (Exception ex) {
            System.out.println("Error (null ISBN): " + ex.getMessage());
        }

        try {
            bookstore.buyBook("123", -1, "email@test.com", "address");
        } catch (Exception ex) {
            System.out.println("Error (negative quantity): " + ex.getMessage());
        }
    }
}