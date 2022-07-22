package week1.day3.Assignments;

import java.util.Scanner;

public class Q6_Age_Criteria {

    public void check_Age(int age1, int age2, int age3){

        //to check the eldest person
        if(age1 > age2 && age1 > age3)
            System.out.println("Person1 is eldest");
        else if(age2 > age1 && age2 > age3)
            System.out.println("Person2 is eldest");
        else
            System.out.println("Person3 is eldest");

        //to check the youngest person
        if(age1 < age2 && age1 < age3)
            System.out.println("Person1 is youngest");
        else if(age2 < age1 && age2 < age3)
            System.out.println("Person2 is youngest");
        else
            System.out.println("Person3 is youngest");



    }

    public static void main(String[] args) {

        Q6_Age_Criteria ageCriteria= new Q6_Age_Criteria();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Age of Person1: ");
        int age1 = scanner.nextInt();

        System.out.println("Enter Age of Person2: ");
        int age2 = scanner.nextInt();

        System.out.println("Enter Age of Person3: ");
        int age3 = scanner.nextInt();

        ageCriteria.check_Age(age1, age2, age3);

    }
}

//    Enter Age of Person1:
//        18
//        Enter Age of Person2:
//        12
//        Enter Age of Person3:
//        21
//        Person3 is eldest
//        Person2 is youngest
//
//        Process finished with exit code 0