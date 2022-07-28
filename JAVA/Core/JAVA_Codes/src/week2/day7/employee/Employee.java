package week2.day7.employee;

import java.util.Scanner;

class Employee{

    int employee_id;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    String employeeName;

//    Employee(int id, String name){
//        this.employee_id= id;
//        this.employeeName = name;
//    }
    Employee(){
    }

    public void computeSalary(){
    }
    public void acceptData(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }

}






