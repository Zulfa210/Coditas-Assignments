package Test6.DaoImplementation;

import Test6.BookPojo.Book;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {
    public void addRecords(Book book);
    public void showAllRecords();
    public void updateRecords();
    public void deleteRecords();

    public void sortById();

    public void sortByPublisher();

    public void publisherWiseAuthor();
}
