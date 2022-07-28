package week2.day7.employee;

import java.util.Scanner;

class WageEmployee extends Employee {

    int hrs;

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getSalary() {
        return salary;
    }

//    public void setSalary(int salary) {
//        this.salary = salary;
//    }

    int rate;
    int salary;

//    WageEmployee(int id, String name, int hrs, int rate){
//        super(id, name);
//        this.hrs = hrs;
//        this.rate = rate;
//    }
    WageEmployee(){
    }
    public void computeSalary(){
        salary = hrs * rate;
    }

    public void acceptData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id");
        int employee_id1 = scanner.nextInt();
        System.out.println("Enter employee name");
        String employee_name1 = scanner.next();
        System.out.println("Enter rate");
        int rate1 = scanner.nextInt();
        System.out.println("Enter hours");
        int hrs1 = scanner.nextInt();

        setEmployee_id(employee_id1);
        setEmployeeName(employee_name1);
        setHrs(hrs1);
        setRate(rate1);

        computeSalary();

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