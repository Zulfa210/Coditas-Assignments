package week2.day7.employee;

import java.util.Scanner;

class Salesperson extends WageEmployee {

    int sales;
    int commission;

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int salary;
//    Salesperson(int id, String n, int hrs, int rate, int sales, int commission){
//        super(id, n, hrs, rate);
//        this.sales = sales;
//        this.commission = commission;
//    }
    public void computeSalary(){
        salary  = salary + (sales * commission);

    }
    public void acceptData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id");
        int employee_id2 = scanner.nextInt();
        System.out.println("Enter employee name");
        String employee_name2 = scanner.next();
        System.out.println("Enter rate");
        int rate2 = scanner.nextInt();
        System.out.println("Enter hours");
        int hrs2 = scanner.nextInt();

        System.out.println("Enter sales");
        int sales = scanner.nextInt();

        System.out.println("Enter commision");
        int commission = scanner.nextInt();

        setEmployee_id(employee_id2);
        setEmployeeName(employee_name2);
        setRate(rate2);
        setHrs(hrs2);
        setCommission(commission);
        setSales(sales);

        computeSalary();

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
