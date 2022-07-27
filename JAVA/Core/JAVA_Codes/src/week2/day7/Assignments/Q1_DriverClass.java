package week2.day7.Assignments;

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

    public void displayData(){
        System.out.println("--------------------------------------------------");
        System.out.println("Name: "+ employeeName);
        System.out.println("ID: "+ employee_id);
        //System.out.println("Name: "+ employeeName);
    }
}

class WageEmployee extends Employee{

    int hrs;
    int rate;

    WageEmployee(int id, String name, int hrs, int rate){
        super(id, name);
        this.hrs = hrs;
        this.rate = rate;
    }
    WageEmployee(){
    }
    public void computeSalary(){
        super.displayData();
        int salary = hrs * rate;
        System.out.println("Salary of WageEmployee is" + salary);
    }


}
/*2. Create SalesPerson class extending WageEmployee with attributes as sales(int) and commission (int)
Override the ComputeSalary() in Salesperson class and print the salary and details of SalesPerson
*/
class Salesperson extends WageEmployee{

    int sales;
    int commission;

    Salesperson(int id, String n, int hrs, int rate, int sales, int commission){
        super(id, n, hrs, rate);
        this.sales = sales;
        this.commission = commission;
    }
    public void computeSalary(){

        super.displayData();
        int salary  = sales * (commission/100);
        System.out.println("Salary of Salesperson is " + salary);

    }

}
/*3 Create Manager class extending Employee class with attributes as fixed salary(int) and
incentives(int) and method computeSalary() to calculate the salary of Manager Print the salary and details of Manager
 */

class Manager extends Employee {

    int fixed_salary;
    int incentives;

    Manager(int id, String name, int fixed_salary, int incentives) {
        super(id, name);
        this.fixed_salary = fixed_salary;
        this.incentives = incentives;
    }

    public void computeSalary() {
        super.displayData();
        int salary = fixed_salary + incentives;
        System.out.println("Salary of Manager is " + salary);
    }
}

/*4. Write a TestEmployee class to print the details of all types of employees (use array[] of Employee class)
creating a driver class to print all details
* */
class TestEmployee{

    public void displayEmployee(){
        //object of wageEmployee class
        Employee employee = new WageEmployee(211, "Zulfa", 8, 1000);
        employee.computeSalary();

        //object of salesperson class
        Employee employee1 = new Salesperson(213, "Priya", 8, 1000, 2300, 1999);
        employee1.computeSalary();

        //object of manager class
        Employee employee2 = new Manager(212, "Ram", 10000, 1000);
        employee2.computeSalary();


    }
}

public class Q1_DriverClass {
    public static void main(String[] args) {

        TestEmployee testEmployee = new TestEmployee();
        testEmployee.displayEmployee();

    }


}
