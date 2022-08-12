package week4.Day16.Assignments.Q2_InputWays;

import java.io.Console;
import java.io.Serializable;

public class ConsoleInput_Employee {
    public static void main(String args[]){
        Console c=System.console();
	System.out.println("Enter Employee name: ");
        String name=c.readLine();
	System.out.println("Enter id: ");
        int id = Integer.parseInt(c.readLine());
	System.out.println("Enter salary: ");
	float salary = Float.parseFloat(c.readLine());

	System.out.println("=========Employee Details by Console=============");
        System.out.println("Employee Name: " + name + "\nEmployee id: " + id + "\nSalary: " + salary);

    
    }
}

/*
Output:

C:\Users\Coditas\Desktop\Java Practise Assignments>javac ConsoleInput_Employee.java

C:\Users\Coditas\Desktop\Java Practise Assignments>java ConsoleInput_Employee
Enter Employee name:
Zulfa
Enter id:
11
Enter salary:
10000
=========Employee Details by Console=============
Employee Name: Zulfa
Employee id: 11
Salary: 10000.0
*/
