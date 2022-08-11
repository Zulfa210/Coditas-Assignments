package week4.Day16;

import java.util.Scanner;

public class ScannerDemo {
    int id;
    String name;
    float marks;



    public void acceptDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter id: ");
        this.id = scanner.nextInt();
        System.out.println("Enter marks: ");
        this.marks = scanner.nextFloat();

    }

    public void displayDetails(){
        System.out.println("=========Employee Details=============");
        System.out.println("Student Name: " + name + "\nStudent id: " +  id + "\nMarks: " + marks);

    }
    public static void main(String[] args) {
        ScannerDemo scannerDemo = new ScannerDemo();
        scannerDemo.acceptDetails();
        scannerDemo.displayDetails();

    }
}

/*
Output:
Enter name:
Zulfa Attar
Enter id:
112
Enter marks:
900
=========Employee Details=============
Student Name: Zulfa Attar
Student id: 112
Marks: 900.0

Process finished with exit code 0
 */