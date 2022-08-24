package week6.Day22.Assignments;

/**
 * @author Zulfa Attar
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class UsingComparator {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no. of Employees to be added: ");
        int noOfEmployees = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Employee> arrayList= new ArrayList<Employee>();
        for(int i = 0; i<noOfEmployees; i++){
            System.out.println("Enter Employee ID: ");
            int employeeId = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter Employee Name: ");
            String employeeName = bufferedReader.readLine();
            System.out.println("Enter Employee City: ");
            String employeeCity = bufferedReader.readLine();

            arrayList.add(new Employee(employeeId, employeeName, employeeCity));

        }

        System.out.println("***************ENTERED DATA************************");
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        int choice;
        do{
            System.out.println("Enter 1 to sort by Employee ID\nEnter 2 to sort by Employee Name" +
                    "\nEnter 3 to sort by Employee City\nEnter 0 to exit");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice){
                case 0:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("***************SORTING BY ID************************");
                    Collections.sort(arrayList, new SortByID());
                    for(int i=0; i<arrayList.size(); i++){
                        System.out.println(arrayList.get(i));
                    }
                    break;
                case 2:
                    System.out.println("***************SORTING BY NAME************************");
                    Collections.sort(arrayList, new SortByName());
                    for(int i=0; i<arrayList.size(); i++){
                        System.out.println(arrayList.get(i));
                    }
                    break;
                case 3:
                    System.out.println("***************SORTING BY CITY************************");
                    Collections.sort(arrayList, new SortByCity());
                    for(int i=0; i<arrayList.size(); i++){
                        System.out.println(arrayList.get(i));
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }while (choice!=0);


    }
}

/*
Output:
"C:\Program Files\Java\jdk1.8.0_333\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\lib\idea_rt.jar=60778:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_333\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\rt.jar;C:\Users\Coditas\Desktop\Coditas-Assignments\JAVA\Core\JAVA_Codes\out\production\Basic_Java_Core" week6.Day22.Assignments.UsingComparator
Enter no. of Employees to be added:
5
Enter Employee ID:
12
Enter Employee Name:
Z
Enter Employee City:
Pune
Enter Employee ID:
2
Enter Employee Name:
X
Enter Employee City:
Mumbai
Enter Employee ID:
5
Enter Employee Name:
A
Enter Employee City:
Kolkata
Enter Employee ID:
8
Enter Employee Name:
D
Enter Employee City:
Nagpur
Enter Employee ID:
90
Enter Employee Name:
Y
Enter Employee City:
Bangalore
***************ENTERED DATA************************
Employee{employeeId=12, employeeName='Z', employeeCity='Pune'}
Employee{employeeId=2, employeeName='X', employeeCity='Mumbai'}
Employee{employeeId=5, employeeName='A', employeeCity='Kolkata'}
Employee{employeeId=8, employeeName='D', employeeCity='Nagpur'}
Employee{employeeId=90, employeeName='Y', employeeCity='Bangalore'}
Enter 1 to sort by Employee ID
Enter 2 to sort by Employee Name
Enter 3 to sort by Employee City
Enter 0 to exit
1
***************SORTING BY ID************************
Employee{employeeId=2, employeeName='X', employeeCity='Mumbai'}
Employee{employeeId=5, employeeName='A', employeeCity='Kolkata'}
Employee{employeeId=8, employeeName='D', employeeCity='Nagpur'}
Employee{employeeId=12, employeeName='Z', employeeCity='Pune'}
Employee{employeeId=90, employeeName='Y', employeeCity='Bangalore'}
Enter 1 to sort by Employee ID
Enter 2 to sort by Employee Name
Enter 3 to sort by Employee City
Enter 0 to exit
2
***************SORTING BY NAME************************
Employee{employeeId=5, employeeName='A', employeeCity='Kolkata'}
Employee{employeeId=8, employeeName='D', employeeCity='Nagpur'}
Employee{employeeId=2, employeeName='X', employeeCity='Mumbai'}
Employee{employeeId=90, employeeName='Y', employeeCity='Bangalore'}
Employee{employeeId=12, employeeName='Z', employeeCity='Pune'}
Enter 1 to sort by Employee ID
Enter 2 to sort by Employee Name
Enter 3 to sort by Employee City
Enter 0 to exit
3
***************SORTING BY CITY************************
Employee{employeeId=90, employeeName='Y', employeeCity='Bangalore'}
Employee{employeeId=5, employeeName='A', employeeCity='Kolkata'}
Employee{employeeId=2, employeeName='X', employeeCity='Mumbai'}
Employee{employeeId=8, employeeName='D', employeeCity='Nagpur'}
Employee{employeeId=12, employeeName='Z', employeeCity='Pune'}
Enter 1 to sort by Employee ID
Enter 2 to sort by Employee Name
Enter 3 to sort by Employee City
Enter 0 to exit
0
Thank you!

Process finished with exit code 0


 */