package com.dao;

import com.bean.Book;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {

    public void addBook(Book book);
    public void displayAllBooks();
    public void getByID(int id);

    public void deleteBook(int id);

    public void updateBook(int id, String bookName);

    public void fetchByRestriction(String authorName);

    public void fetchByOrder(String order, String propertyName);

    public void fetchByProjection(String propertyName);

}
