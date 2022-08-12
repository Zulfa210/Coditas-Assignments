package week4.Day16.Assignments.Q2_InputWays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader_Input {
    public void acceptDetails(){
        try {

            InputStreamReader r=new InputStreamReader(System.in);
            String name= null;
            BufferedReader br=new BufferedReader(r);
            System.out.println("Enter Employee name");
            name = br.readLine();
            System.out.println("Enter id: ");
            int id= Integer.parseInt(br.readLine());

            System.out.println("Enter salary: ");
            float salary= Float.parseFloat(br.readLine());

            Employee employee = new Employee(id, name, salary);
            new BufferReader_Input().displayDetails( employee);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void displayDetails(Employee employee){
        System.out.println("=========Employee Details by BufferedReader=============");
        System.out.println("Employee Name: " + employee.name + "\nEmployee id: " +  employee.eid + "\nSalary: " + employee.esal);

    }
    public static void main(String[] args) {
        new BufferReader_Input().acceptDetails();

    }
}

/*
output:
Enter Employee name
Zulfa Attar
Enter id:
112
Enter salary:
9000
=========Employee Details by BufferedReader=============
Employee Name: Zulfa Attar
Employee id: 112
Salary: 9000.0

Process finished with exit code 0
 */