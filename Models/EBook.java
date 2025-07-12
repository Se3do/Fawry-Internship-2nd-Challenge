package Models;
public class EBook extends Book{
    private String filetype;
    
    public EBook(String isbn, String title, int year, double price, String authorName, String filetype) {
        super(isbn, title, year, price, authorName);
        this.filetype = filetype;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if(quantity != 1)
            throw new IllegalArgumentException("EBooks can be only bought one at a time !!");

        System.out.println("Sending EBook '" + title + "' x" + quantity + " to email - " + email);
        double amount = price * quantity;
        System.out.println("Paid amount: $" + amount);
        return amount;
    }
    
}
