package week7.Day28.DaoDemo.MainDriver;

import week7.Day28.DaoDemo.DaoOperations.DaoOperationsImplementation;

import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
public class StudentDriverClass {
    public static void main(String[] args) {
        DaoOperationsImplementation studentOperations = new DaoOperationsImplementation();
//        studentOperations.alterTable();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. Exit" +
                    "\n1. Add new records" +
                    "\n2. Fetch All Records" +
                    "\n3. Fetch only those records who are in TY and having percentage >70 " +
                    "\n4. Fetch only those records whose id in range 1-10" +
                    "\n5. Delete Record");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);

                case 3:
                    studentOperations.fetchRecordsOfTY();
                    break;
                case 4:
                    studentOperations.fetchRecordsBelow10();
                    break;

                case 1:
                    studentOperations.addStudent();
                    break;

                case 2:
                    studentOperations.showAllRecords();
                    break;
                case 5:
                    studentOperations.deleteRecords();
                    break;

                default:
                    System.out.println("Invalid Input");
            }

        } while (choice != 0);
    }
}
