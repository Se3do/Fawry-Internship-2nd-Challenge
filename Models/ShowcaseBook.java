package Models;
public class ShowcaseBook extends Book{

    public ShowcaseBook(String isbn, String title, int year, double price, String authorName) {
        super(isbn, title, year, 0.0, authorName);
    }

    @Override
    public double buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Showcase books are not for sale !!");
    }
    
}
