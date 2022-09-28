package com.bean;

import com.dao.DaoOperationsImplementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zulfa Attar
 */
public class MainApplication {

    public void menu(){
        try {
            DaoOperationsImplementation daoOperations = new DaoOperationsImplementation();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int choice;

            do {
                System.out.println("0. Exit\n1. Insert Book" +
                        "\n2. Get All Books" +
                        "\n3. Get Book by ID" +
                        "\n4. Update book name " +
                        "\n5. Delete book" +
                        "\n6. Fetch by Restriction" +
                        "\n7. Fetch by Order" +
                        "\n8. Fetch By Projection");

                choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Enter Book name, author name");
                        Book book = new Book();
                        book.setBookName(bufferedReader.readLine());
                        book.setAuthorName(bufferedReader.readLine());
                        daoOperations.addBook(book);
                        break;

                    case 2:
                        daoOperations.displayAllBooks();
                        break;

                    case 3:
                        System.out.println("Enter id: ");
                        int id = Integer.parseInt(bufferedReader.readLine());
                        daoOperations.getByID(id);
                        break;

                    case 4:
                        System.out.println("Enter book id: ");
                        int bookId = Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Enter new book name");
                        String bookName = bufferedReader.readLine();
                        daoOperations.updateBook(bookId, bookName);
                        break;

                    case 5:
                        System.out.println("Enter book id: ");
                        int bookIdd = Integer.parseInt(bufferedReader.readLine());
                        daoOperations.deleteBook(bookIdd);
                        break;

                    case 6:
                        System.out.println("Enter author name");
                        String authorName = bufferedReader.readLine();
                        daoOperations.fetchByRestriction(authorName);
                        break;

                    case 7:
                        System.out.println("Enter order and property Name");
                        daoOperations.fetchByOrder(bufferedReader.readLine(), bufferedReader.readLine());
                        break;

                    case 8:
                        System.out.println("Enter property Name");
                        daoOperations.fetchByProjection(bufferedReader.readLine());
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }


            } while (choice != 0);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainApplication().menu();

    }
}
