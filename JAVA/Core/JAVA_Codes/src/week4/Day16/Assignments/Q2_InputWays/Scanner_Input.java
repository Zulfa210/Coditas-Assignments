package week4.Day16.Assignments.Q2_InputWays;
/**
 * 2 )WRITE A PROGRAM FOR ACCEPTING DETAILS (acceptDetails0) OF AN EMPLOYEE AND
 * DISPLAY ALL DETAILS(displayDetails(0)
 * USE ALL 4 WAYS
 * =>CREATE SEPARATE FILES FOR EVERY
 * WAY(SCANNER,BUFFEREDREADER,CONSOLE,CLI)
 *
 * @author Zulfa
 */

import java.util.Scanner;

public class Scanner_Input {
    public void acceptDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter id: ");
        int eid = scanner.nextInt();
        System.out.println("Enter salary: ");
        float salary = scanner.nextFloat();

        Employee employee = new Employee(eid, name, salary);

        new Scanner_Input().displayDetails( employee);

    }

    public void displayDetails(Employee employee){
        System.out.println("=========Employee Details by Scanner=============");
        System.out.println("Employee Name: " + employee.name + "\nEmployee id: " +  employee.eid + "\nSalary: " + employee.esal);

    }

    public static void main(String[] args) {
        new Scanner_Input().acceptDetails();
    }
}

/*
Output:
"C:\Program Files\Java\jdk1.8.0_333\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\lib\idea_rt.jar=50871:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_333\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_333\jre\lib\rt.jar;C:\Users\Coditas\Desktop\Coditas-Assignments\JAVA\Core\JAVA_Codes\out\production\Basic_Java_Core" week4.Day16.Assignments.Q2_InputWays.Scanner_Input
Enter Employee name:
Zulfa Attar
Enter id:
1122
Enter salary:
10000
=========Employee Details by Scanner=============
Employee Name: Zulfa Attar
Employee id: 1122
Salary: 10000.0

Process finished with exit code 0
 */