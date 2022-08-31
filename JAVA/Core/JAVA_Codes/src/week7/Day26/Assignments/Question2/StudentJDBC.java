package week7.Day26.Assignments.Question2;

import week7.Day26.Assignments.Question1.Employee;
import week7.Day26.Assignments.Question1.EmployeeOperations;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Zulfa Attar
 * 2)Consider entity Student->Student(id,name,year,percentage,city)
 * case1=>alter table and add "Gender" column in it
 * case2=>fetch only those records who are in TY and having percentage >70
 * case3=>fetch only those records whose id in range 1-10
 * case4=>At the same time perform below operations
 * case4.1>1)add 3 new records
 * case4.2=>2)update students, if gender="M" then change name to
 * "Ajay=>"Mr. Ajay" and if genderF then change name to "Aarti"=>"Ms.Aarti".
 * case4.3->remove those student who are in last year
 * ====> Try to print data on console using "format" or suitable methods with
 * indentation
 */

public class StudentJDBC {
    public static void main(String[] args) {

        StudentOperations studentOperations = new StudentOperations();
//        studentOperations.alterTable();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("0. Exit" +
                    "\n1. Fetch only those records who are in TY and having percentage >70 " +
                    "\n2. Fetch only those records whose id in range 1-10" +
                    "\n3. Add new records" +
                    "\n4. Add Mr. & Ms. Prefix to names" +
                    "\n5. Delete last year students");
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);

                case 1:
                    studentOperations.fetchRecordsOfTY();
                    break;
                case 2:
                    studentOperations.fetchRecordsBelow10();
                    break;

                case 3:
                    studentOperations.addStudent();
                    break;

                case 4:
                    studentOperations.addPrefixToName();
                    break;

                case 5:
                    studentOperations.removeLastYearStudents();
                    break;

                default:
                    System.out.println("Invalid Input");
            }

        }while (choice!=0);
    }
}

/*
Output:
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
1
ID        NAME                YEAR                PERCENTAGE          CITY           GENDER
2         Adi                 TY                  82.0                Mumbai         male
3         Abhi                TY                  81.0                Chennai        male
11        Zaid                TY                  90.0                Pune           male
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
2
ID        NAME                YEAR                PERCENTAGE          CITY           GENDER
1         Zulfa               SY                  92.0                Pune           female
2         Adi                 TY                  82.0                Mumbai         male
3         Abhi                TY                  81.0                Chennai        male
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
3
Enter the number of Students you want to add:
3
Enter Student id:
16
Enter Student name:
Ved
Enter Student year:
TY
Enter Student percentage:
89
Enter Student city:
Pune
Enter Student gender:
male
Enter Student id:
17
Enter Student name:
Muskan
Enter Student year:
SY
Enter Student percentage:
68
Enter Student city:
Kanpur
Enter Student gender:
female
Enter Student id:
19
Enter Student name:
Shubh
Enter Student year:
TY
Enter Student percentage:
98
Enter Student city:
Delhi
Enter Student gender:
male
ID        NAME                YEAR                PERCENTAGE          CITY           GENDER
1         Zulfa               SY                  92.0                Pune           female
2         Adi                 TY                  82.0                Mumbai         male
3         Abhi                TY                  81.0                Chennai        male
14        Dev                 FY                  91.0                Kolkata        male
15        Ram                 SY                  95.0                Mumbai         male
11        Zaid                TY                  90.0                Pune           male
13        Sara                SY                  90.0                Delhi          female
16        Ved                 TY                  89.0                Pune           male
17        Muskan              SY                  68.0                Kanpur         female
19        Shubh               TY                  98.0                Delhi          male
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
4
ID        NAME                YEAR                PERCENTAGE          CITY           GENDER
1         Ms. Zulfa           SY                  92.0                Pune           female
2         Mr. Adi             TY                  82.0                Mumbai         male
3         Mr. Abhi            TY                  81.0                Chennai        male
14        Mr. Dev             FY                  91.0                Kolkata        male
15        Mr. Ram             SY                  95.0                Mumbai         male
11        Mr. Zaid            TY                  90.0                Pune           male
13        Ms. Sara            SY                  90.0                Delhi          female
16        Mr. Ved             TY                  89.0                Pune           male
17        Ms. Muskan          SY                  68.0                Kanpur         female
19        Mr. Shubh           TY                  98.0                Delhi          male
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
5
ID        NAME                YEAR                PERCENTAGE          CITY           GENDER
1         Ms. Zulfa           SY                  92.0                Pune           female
14        Mr. Dev             FY                  91.0                Kolkata        male
15        Mr. Ram             SY                  95.0                Mumbai         male
13        Ms. Sara            SY                  90.0                Delhi          female
17        Ms. Muskan          SY                  68.0                Kanpur         female
0. Exit
1. Fetch only those records who are in TY and having percentage >70
2. Fetch only those records whose id in range 1-10
3. Add new records
4. Add Mr. & Ms. Prefix to names
5. Delete last year students
0

Process finished with exit code 0
 */