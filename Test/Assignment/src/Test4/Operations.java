package Test4;

import java.util.Scanner;

/**
 * @author Zulfa Attar
 */

class Operations{

    public void updateDetails(Student student){

        System.out.println("Enter the Field you want to update: "+
                "\n1. First name: \n2. Last Name: \n3. City\n4. TechStack\n5. Mobile no.");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter First Name: ");
                String firstNameNew = scanner.next();
                student.firstName = firstNameNew;
                break;

            case 2:
                System.out.println("Enter Last Name: ");
                String lastNameNew = scanner.next();
                student.lastName = lastNameNew;
                break;

            case 3:
                System.out.println("Enter City: ");
                String cityNew = scanner.next();
                student.city = cityNew;
                break;

            case 4:
                System.out.println("Enter TechStack: ");
                String techStackNew = scanner.next();
                student.techStack = techStackNew;
                break;

            case 5:
                System.out.println("Enter Mobile no.: ");
                int mobileNoNew = scanner.nextInt();
                student.mobileNo = mobileNoNew;
                break;

            default:
                System.out.println("Invalid choice");
        }

    }
    void showMenu(){
        System.out.println("Enter your Choice:\n1. Insert\n2. Update\n3. Remove\n4. Display\n5. Exit");
    }

    void deleteStudent(Student student){
        student.studentID = 0;
        student.firstName = null;
        student.lastName = null;
        student.city = null;
        student.techStack = null;
        student.mobileNo = 0;
        student.scanner = null;


    }

    void displayStudent(Student student[], int noOfStudents){

        for (int i =0; i<noOfStudents; i++){
            if(student[i].studentID != 0)
                System.out.println(student[i].toString());
        }
        System.out.println("No of Students: " + noOfStudents);
    }
}