package week2.day7.Assignments;

import java.util.Scanner;

/**
 *Create class WageEmployee extending Employee class with attributes as hrs (int)and rate(int) and
 * method computeSalary() to calculate the salary.
 * Print the salary and details of WageEmployee (Note: Use the previous Employee classes Accept the values from
 * the user Default, Parameterised Constructor and toString() to be written in all the classes)
 *
 */
class Employee{

    int employee_id;
    String employeeName;

    Employee(int id, String name){
        this.employee_id= id;
        this.employeeName = name;
    }
    Employee(){
    }

    public void computeSalary(){
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

}

class WageEmployee extends Employee{

    int hrs;
    int rate;
    int salary;

    WageEmployee(int id, String name, int hrs, int rate){
        super(id, name);
        this.hrs = hrs;
        this.rate = rate;
    }
    WageEmployee(){
    }
    public void computeSalary(){
        salary = hrs * rate;
    }

    @Override
    public String toString() {
        return "WageEmployee{" +
                ", employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                ", hrs=" + hrs +
                ", rate=" + rate +
                ", salary=" + salary +
                '}';
    }


}
/*2. Create SalesPerson class extending WageEmployee with attributes as sales(int) and commission (int)
Override the ComputeSalary() in Salesperson class and print the salary and details of SalesPerson
*/
class Salesperson extends WageEmployee{

    int sales;
    int commission;
    int salary;
    Salesperson(int id, String n, int hrs, int rate, int sales, int commission){
        super(id, n, hrs, rate);
        this.sales = sales;
        this.commission = commission;
    }
    public void computeSalary(){
        salary  = salary + (sales * commission);

    }

    @Override
    public String toString() {
        return "Salesperson{" +
                ", employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                ", sales=" + sales +
                ", commission=" + commission +
                ", hrs=" + hrs +
                ", rate=" + rate +
                ", salary=" + salary +
                '}';
    }
}
/*3 Create Manager class extending Employee class with attributes as fixed salary(int) and
incentives(int) and method computeSalary() to calculate the salary of Manager Print the salary and details of Manager
 */

class Manager extends Employee {


    int fixed_salary;
    int incentives;
    int salary;

    Manager(int id, String name, int fixed_salary, int incentives) {
        super(id, name);
        this.fixed_salary = fixed_salary;
        this.incentives = incentives;
    }

    public void computeSalary() {
        salary = fixed_salary + incentives;
    }

    @Override
    public String toString() {
        return "Manager{" +
                ", employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                ", fixed_salary=" + fixed_salary +
                ", incentives=" + incentives +
                ", salary=" + salary +
                '}';
    }
}

/*4. Write a TestEmployee class to print the details of all types of employees (use array[] of Employee class)
creating a driver class to print all details
* */
class TestEmployee{

    public void displayEmployee(){

        Employee employee[]=new Employee[3];
        //object of wageEmployee class
        Employee employee1 = new WageEmployee(211, "Zulfa", 8, 1000);
        employee1.computeSalary();

        //object of salesperson class
        Employee employee2 = new Salesperson(213, "Zaid", 8, 1000, 2300, 1999);
        employee2.computeSalary();

        //object of manager class
        Employee employee3 = new Manager(212, "Ram", 10000, 1000);
        employee3.computeSalary();

        employee[0] = employee1;
        employee[1] = employee2;
        employee[2] = employee3;


        new TestEmployee().displayEmployeeDetail(employee);
    }

    public void displayEmployeeDetail(Employee[] e)
    {
        for (int i=0;i<e.length;i++)
        {
            System.out.println("========================Employee "+(i+1)+" Details======================");
            System.out.println(e[i]);
        }
    }
}

public class Q1_DriverClass {
    public static void main(String[] args) {

        TestEmployee testEmployee = new TestEmployee();
        testEmployee.displayEmployee();

    }

}
/*Output:

========================Employee 1 Details======================
WageEmployee{, employee_id=211, employeeName='Zulfa', hrs=8, rate=1000, salary=8000}
========================Employee 2 Details======================
Salesperson{, employee_id=213, employeeName='Zaid', sales=2300, commission=1999, hrs=8, rate=1000, salary=4597700}
========================Employee 3 Details======================
Manager{, employee_id=212, employeeName='Ram', fixed_salary=10000, incentives=1000, salary=11000}

Process finished with exit code 0


 */
