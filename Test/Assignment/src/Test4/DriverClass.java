package Test4;

import java.util.Scanner;

/**
 *
 *
 * @author Zulfa Attar
 */

public class DriverClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Operations operations = new Operations();
        Student student[] = new Student[10];
        int noOfStudents = 0;
        int x =0;
        int choice;
        do{
            operations.showMenu();
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    Student student1 = new Student();
                    student1.acceptDetails();
                    student[x++] = student1;
                    noOfStudents++;
                    break;

                case 2:
                    System.out.println("Enter Student id from: ");
                    for (int i = 0; i<x; i++){
                        System.out.println(student[i].studentID);
                    }

                    int studentId= scanner.nextInt();

                    for (int i = 0; i<x; i++){
                        if(student[i].studentID ==studentId){
                            operations.updateDetails(student[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Student id: ");
                    int studentId2= scanner.nextInt();

                    for (int i = 0; i<noOfStudents; i++){
                        if(student[i].studentID ==studentId2){
                            operations.deleteStudent(student[i]);
                        }
                    }
                    noOfStudents--;
                    break;

                case 4:
                    operations.displayStudent(student, x);
                    break;

                case 5:
                    System.exit(0);

            }

        }while (choice != 5);
    }
}

/*Output
"C:\Program Files\Java\jdk1.8.0_333\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\lib\idea_rt.jar=53684:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_333\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\rt.jar;C:\Users\Coditas\Desktop\Coditas-Assignments\Test\out\production\Test" Test4.DriverClass
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
1
Enter Student ID:
111
Enter First Name:
Zulfa
Enter Last Name:
Attar
Enter City:
Pune
Enter TechStack:
Java
Enter Mobile no.:
987654321
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
1
Enter Student ID:
112
Enter First Name:
Yash
Enter Last Name:
Shinde
Enter City:
Mumbai
Enter TechStack:
React
Enter Mobile no.:
89033331
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
4
Student{
studentID=111
firstName='Zulfa'
lastName='Attar'
city='Pune'
techStack='Java'
mobileNo=987654321
}
Student{
studentID=112
firstName='Yash'
lastName='Shinde'
city='Mumbai'
techStack='React'
mobileNo=89033331
}
No of Students: 2
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
2
Enter Student id from:
111
112
111
Enter the Field you want to update:
1. First name:
2. Last Name:
3. City
4. TechStack
5. Mobile no.
3
Enter City:
Kolkata
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
4
Student{
studentID=111
firstName='Zulfa'
lastName='Attar'
city='Kolkata'
techStack='Java'
mobileNo=987654321
}
Student{
studentID=112
firstName='Yash'
lastName='Shinde'
city='Mumbai'
techStack='React'
mobileNo=89033331
}
No of Students: 2
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
3
Enter Student id:
112
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
4
Student{
studentID=111
firstName='Zulfa'
lastName='Attar'
city='Kolkata'
techStack='Java'
mobileNo=987654321
}
No of Students: 2
Enter your Choice:
1. Insert
2. Update
3. Remove
4. Display
5. Exit
5

Process finished with exit code 0

 */