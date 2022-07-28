package week2.day7.employee;

import java.util.Scanner;

public class TestEmployee {
    public void displayEmployeeDetail(Employee[] e)
    {
        for (int i=0;i<e.length;i++)
        {
            System.out.println("========================Employee "+(i+1)+" Details======================");
            System.out.println(e[i]);
        }
    }

    public static void main(String[] args) {

        int count, type;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter No. of Employees to be added: ");
        count = scanner.nextInt();

        Employee employee[] = new Employee[count];

        for(int i =0 ; i < count; i++){

            System.out.println("Enter the type of employee: \n 1. WageEmployee \n 2. Salesperson \n 3. Manager ");
            type = scanner.nextInt();

            switch(type){

                case 1:

                    employee [i] = new WageEmployee();
                    employee[i].acceptData();
                    break;

                case 2:
                    employee [i] = new Salesperson();
                    employee[i].acceptData();
                    break;

                case 3:
                    employee [i] = new Manager();
                    employee[i].acceptData();
                    break;

                default:
                    System.out.println("Invalid type");

            }
        }

        new TestEmployee().displayEmployeeDetail(employee);

    }
}
