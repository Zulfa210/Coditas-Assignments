package Test6.DaoImplementation;

import Test6.BookPojo.Book;
import Test6.ConnectionMaker.ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
public class DaoOperationsImplementation implements DaoOperations{

    Scanner scanner = new Scanner(System.in);
    Connection connection = ConnectionMaker.getConnection();
    Statement statement;
    ResultSet resultSet;
    public void addBook(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book id:");
        int id= scanner.nextInt();
        System.out.println("Enter Book name: ");
        String name = scanner.next();
        System.out.println("Enter Book publisher: ");
        String publisher = scanner.next();
        System.out.println("Enter Book price: ");
        float price = scanner.nextFloat();
        System.out.println("Enter Book author: ");
        String author = scanner.next();

        Book book = new Book(id,name, publisher,price, author);
        addRecords(book);


    }

    @Override
    public void addRecords(Book book) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into book values (?,?,?,?,?)");
            preparedStatement.setInt(1, book.bookId);
            preparedStatement.setString(2, book.bookName);
            preparedStatement.setString(3, book.bookPublisher);
            preparedStatement.setFloat(4,book.bookPrice);
            preparedStatement.setString(5, book.bookAuthor);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showAllRecords() {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from book");

            System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n', "ID","NAME","PUBLISHER", "PRICE", "AUTHOR" );

            while (resultSet.next()){
                System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n',
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getFloat(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateRecords() {

        try {
            showAllRecords();
            PreparedStatement preparedStatement;
            System.out.println("Enter id to update: ");
            int id = scanner.nextInt();

            System.out.println("Enter choice to update: \n 1.Name \n2. Publisher \n3.Price \n4.Author");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    preparedStatement = connection.prepareStatement("Update book set name = ? where id = ?");
                    System.out.println("Enter Book name: ");
                    String name = scanner.next();
                    preparedStatement.setString(1,name);
                    preparedStatement.setInt(2,id);
                    preparedStatement.executeUpdate();
                    break;

                case 2:
                    preparedStatement = connection.prepareStatement("Update book set publisher = ? where id = ?");
                    System.out.println("Enter Book publisher: ");
                    String publisher = scanner.next();
                    preparedStatement.setString(1,publisher);
                    preparedStatement.setInt(2,id);
                    preparedStatement.executeUpdate();
                    break;

                case 3:
                    preparedStatement = connection.prepareStatement("Update book set price = ? where id = ?");
                    System.out.println("Enter Book price: ");
                    float price1 = scanner.nextFloat();
                    preparedStatement.setFloat(1,price1);
                    preparedStatement.setInt(2,id);
                    preparedStatement.executeUpdate();
                    break;

                case 4:
                    preparedStatement = connection.prepareStatement("Update book set author = ? where id = ?");
                    System.out.println("Enter Book author: ");
                    String author = scanner.next();
                    preparedStatement.setString(1,author);
                    preparedStatement.setInt(2,id);
                    preparedStatement.executeUpdate();
                    break;
            }
            showAllRecords();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteRecords() {
        try {

            showAllRecords();
            System.out.println("Enter book id: ");
            int id = scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            showAllRecords();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortById() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from book order by id desc");

            System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n', "ID","NAME","PUBLISHER", "PRICE", "AUTHOR" );

            while (resultSet.next()){
                System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n',
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getFloat(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortByPublisher() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from book order by publisher");

            System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n', "ID","NAME","PUBLISHER", "PRICE", "AUTHOR" );

            while (resultSet.next()){
                System.out.printf("%-15s" +"%-15s" +"%-15s" +"%-15s" +"%-15s" +'\n',
                        resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getFloat(4), resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void publisherWiseAuthor() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select a.publisher, b.author from book b inner join book a where a.id = b.id;");

            System.out.printf("%-15s" +"%-15s"  +'\n',"PUBLISHER", "AUTHOR" );

            while (resultSet.next()){
                System.out.printf("%-15s" +"%-15s"  +'\n',
                        resultSet.getString(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
