package com.bean;

import com.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        Book book;


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {

            ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("SpringJT.xml");
            BookDao bookDao= applicationContext.getBean("bookdao", BookDao.class);
            int choice, result;
            do {
                System.out.println("1. Insert \n2. Update\n3. Delete book\n4 .Fetch All. \n5. Fetch Book");

                choice = Integer.parseInt(bufferedReader.readLine());

                switch (choice){
                    case 1:
                        System.out.println("Enter book name, author name and price");
                        book = new Book();
                        book.setBookName(bufferedReader.readLine());
                        book.setAuthorName(bufferedReader.readLine());
                        book.setPrice(Float.parseFloat(bufferedReader.readLine()));

                        result = bookDao.insertBook(book);
                        if(result>0){
                            System.out.println("Done");
                        }else{
                            System.out.println("error");
                        }
                        break;

                    case 2:
                        System.out.println("Enter book name : ");
                        String bookName = bufferedReader.readLine();
                        System.out.println("Enter book price: ");
                        float bookPrice = Float.parseFloat(bufferedReader.readLine());
                        result = bookDao.updateBook(bookName,bookPrice);
                        if(result>0){
                            System.out.println("Done");
                        }else{
                            System.out.println("error");
                        }
                        break;

                    case 3:
                        System.out.println("Enter book name : ");
                        String deleteBookName = bufferedReader.readLine();
                        result = bookDao.deleteBook(deleteBookName);
                        if(result>0){
                            System.out.println("Done");
                        }else{
                            System.out.println("error");
                        }
                        break;

                    case 4:
                        List books = bookDao.fetchAllBooks();
                        break;
                    case 5:
                        System.out.println("Enter book id: ");
                        int bid = Integer.parseInt(bufferedReader.readLine());
                        System.out.println(bookDao.fetchUsingResultSet(bid));
                }


            } while (choice != 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
