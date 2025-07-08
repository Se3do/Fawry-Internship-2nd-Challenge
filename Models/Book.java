package Models;
public abstract class Book{
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;
    protected String authorName;

    public Book(String isbn, String title, int year, double price, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public abstract double buy(int quantity, String email, String address);

    @Override
    public String toString() {
        return title + " (" + isbn + ") by " + authorName + ", year: " + year + ", Price: $" + price;
    }
}