package week4.Day16.Assignments;
/**
 * Q.1)EXECUTE SIMPLE SCANNER EXAMPLE FOR STUDENT(ID, NAME,MARKS)
 * CASE1=>ACCEPT DATA IN NAME,ID,MARKS SEQUENCE
 *          >USING nextLine() method
 * CASE2->ACCEPT DATA IN ID,MARKS,STRING SEQUENCE
 *          can select as per your choice or as per logic
 */

import java.util.Scanner;

public class Q1_ScannerDemo {
    int id;
    String name;
    float marks;



    public void acceptDetails(){
        //case 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter id: ");
        this.id = scanner.nextInt();
        System.out.println("Enter marks: ");
        this.marks = scanner.nextFloat();

    }

    public void acceptDetails2(){
        //case2
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id: ");
        //this.id = Integer.parseInt(scanner.nextLine());
        this.id = scanner.nextInt();
        System.out.println("Enter marks: ");
        this.marks = scanner.nextFloat();
        //this.marks =Float.parseFloat(scanner.nextLine());

        //scanner.skip("\\R?");
        System.out.println("Enter first name: ");
        this.name = scanner.next();

    }

    public void displayDetails(){
        System.out.println("=========Student Details=============");
        System.out.println("Student Name: " + name + "\nStudent id: " +  id + "\nMarks: " + marks);

    }
    public static void main(String[] args) {
        Q1_ScannerDemo scannerDemo = new Q1_ScannerDemo();
        scannerDemo.acceptDetails();
        Q1_ScannerDemo scannerDemo1 = new Q1_ScannerDemo();
        scannerDemo1.acceptDetails2();

        System.out.println("==================CASE 1===================");
        scannerDemo.displayDetails();

        System.out.println("==================CASE 2===================");
        scannerDemo1.displayDetails();

    }
}

/*
Output:
Enter name:
Zulfa Attar
Enter id:
11
Enter marks:
90
Enter id:
12
Enter marks:
99
Enter first name:
Zulfa
==================CASE 1===================
=========Student Details=============
Student Name: Zulfa Attar
Student id: 11
Marks: 90.0
==================CASE 2===================
=========Student Details=============
Student Name: Zulfa
Student id: 12
Marks: 99.0

Process finished with exit code 0
 */