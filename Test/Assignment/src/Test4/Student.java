package Test4;

import java.util.Scanner;

/**
 * @author Zulfa Attar
 */
class Student{
    int studentID;
    String firstName;
    String lastName;
    String city;
    String techStack;
    int mobileNo;


    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "Student{" +
                "\nstudentID=" + studentID +
                "\nfirstName='" + firstName + '\'' +
                "\nlastName='" + lastName + '\'' +
                "\ncity='" + city + '\'' +
                "\ntechStack='" + techStack + '\'' +
                "\nmobileNo=" + mobileNo +
                "\n}";
    }

    public void acceptDetails(){


        System.out.println("Enter Student ID: ");
        int ID = scanner.nextInt();
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.println("Enter City: ");
        String city = scanner.next();
        System.out.println("Enter TechStack: ");
        String techStack = scanner.next();
        System.out.println("Enter Mobile no.: ");
        int mobileNo = scanner.nextInt();

        this.studentID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.techStack = techStack;
        this.mobileNo = mobileNo;
      //  this.scanner = scanner;


    }

}