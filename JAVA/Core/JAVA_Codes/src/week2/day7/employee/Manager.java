package week2.day7.employee;

import java.util.Scanner;

class Manager extends Employee {


    int fixed_salary;
    int incentives;

    public int getFixed_salary() {
        return fixed_salary;
    }

    public void setFixed_salary(int fixed_salary) {
        this.fixed_salary = fixed_salary;
    }

    public int getIncentives() {
        return incentives;
    }

    public void setIncentives(int incentives) {
        this.incentives = incentives;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int salary;

//    Manager(int id, String name, int fixed_salary, int incentives) {
//        super(id, name);
//        this.fixed_salary = fixed_salary;
//        this.incentives = incentives;
//    }

    public void computeSalary() {
        salary = fixed_salary + incentives;
    }

    public void acceptData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id");
        int employee_id3 = scanner.nextInt();
        System.out.println("Enter employee name");
        String employee_name3 = scanner.next();
        System.out.println("Enter fixed salary:");
        int fixed_Salary = scanner.nextInt();
        System.out.println("Enter incentives");
        int incentives = scanner.nextInt();

        setEmployee_id(employee_id3);
        setEmployeeName(employee_name3);
        setFixed_salary(fixed_Salary);
        setIncentives(incentives);

        computeSalary();

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
