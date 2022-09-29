package com.bean;

/**
 * @author Zulfa Attar
 */
public class PartTimeEmployee extends Employee{
    private int salaryPerHours, noOfHours;

    public int getSalaryPerHours() {
        return salaryPerHours;
    }

    public void setSalaryPerHours(int salaryPerHours) {
        this.salaryPerHours = salaryPerHours;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }

    public PartTimeEmployee(int salaryPerHours, int noOfHours) {
        this.salaryPerHours = salaryPerHours;
        this.noOfHours = noOfHours;
    }

    public PartTimeEmployee(int employeeId, String employeeName, int salaryPerHours, int noOfHours) {
        super(employeeId, employeeName);
        this.salaryPerHours = salaryPerHours;
        this.noOfHours = noOfHours;
    }
}
