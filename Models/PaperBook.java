package Models;
public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String authorName, int stock) {
        super(isbn, title, year, price, authorName);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if(stock < quantity) 
            throw new IllegalArgumentException("Not enough stock available !!");
        stock -= quantity;
        
        System.out.println("Sending Book '" + title + "' x" + quantity + " to address - " + address);
        double amount = price * quantity;
        System.out.println("Paid amount: $" + amount);
        return amount;
    }
    
}
