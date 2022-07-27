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
    String gender;


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
class Manager extends Employee {

    int fixed_salary;
    int incentives;

    Manager(int id, String name, int fixed_salary, int incentives) {
        this.fixed_salary = fixed_salary;
        this.incentives = incentives;
    }

    public void computeSalary() {
        super.displayData();
        int salary = fixed_salary + incentives;
        System.out.println("Salary of Manager is " + salary);
    }
}

class TestEmployee{

    public void displayEmployee(){
        Employee employee = new WageEmployee(212, "Zulfa", 8, 1000);
        employee.computeSalary();

        Employee employee2 = new Manager(211, "Ram", 10000, 1000);
        employee.computeSalary();

        Employee employee1 = new Salesperson(213, "Priya", 8, 1000, 2300, 1999);
        employee1.computeSalary();
    }
}

public class Q1_WageEmployee {
    public static void main(String[] args) {

        TestEmployee testEmployee = new TestEmployee();
        testEmployee.displayEmployee();

    }


}
