package Test6.Main;

import Test6.DaoImplementation.DaoOperations;
import Test6.DaoImplementation.DaoOperationsImplementation;

import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
public class MainBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaoOperationsImplementation operations = new DaoOperationsImplementation();

        int choice;
        do{
            System.out.println("0. Exit\n1. Insert data\n2. Show Data\n3. Update Data\n4. Delete Data \n5. Sort By ID\n6. Sort By Publisher\n7. Publisher wise Author");
            choice = scanner.nextInt();
            switch(choice){

                case 0:
                    System.exit(0);
                case  1:
                    operations.addBook();
                    break;

                case 2:
                    operations.showAllRecords();
                    break;

                case 3:
                    operations.updateRecords();
                    break;

                case 4:
                    operations.deleteRecords();
                    break;

                case 5:
                    operations.sortById();
                    break;
                case 6:
                    operations.sortByPublisher();
                    break;
                case 7:
                    operations.publisherWiseAuthor();
                    break;

            }

        }while (choice != 0);
    }
}
