package Test6.BookPojo;

/**
 * @author Zulfa Attar
 */
public class Book {
    public int bookId;
    public String bookName;
    public String bookPublisher;
    public float bookPrice;
    public String bookAuthor;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }

    public Book(int bookId, String bookName, String bookPublisher, float bookPrice, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
    }
}
