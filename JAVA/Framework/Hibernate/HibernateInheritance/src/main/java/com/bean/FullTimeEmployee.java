package com.bean;

/**
 * @author Zulfa Attar
 */
public class FullTimeEmployee extends Employee{

    private int fixedSalary, extraNoOfHours, extraHoursSalary;

    public FullTimeEmployee(int fixedSalary, int extraNoOfHours, int extraHoursSalary) {
        this.fixedSalary = fixedSalary;
        this.extraNoOfHours = extraNoOfHours;
        this.extraHoursSalary = extraHoursSalary;
    }

    public FullTimeEmployee(int employeeId, String employeeName, int fixedSalary, int extraNoOfHours, int extraHoursSalary) {
        super(employeeId, employeeName);
        this.fixedSalary = fixedSalary;
        this.extraNoOfHours = extraNoOfHours;
        this.extraHoursSalary = extraHoursSalary;
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public int getExtraNoOfHours() {
        return extraNoOfHours;
    }

    public void setExtraNoOfHours(int extraNoOfHours) {
        this.extraNoOfHours = extraNoOfHours;
    }

    public int getExtraHoursSalary() {
        return extraHoursSalary;
    }

    public void setExtraHoursSalary(int extraHoursSalary) {
        this.extraHoursSalary = extraHoursSalary;
    }
}
