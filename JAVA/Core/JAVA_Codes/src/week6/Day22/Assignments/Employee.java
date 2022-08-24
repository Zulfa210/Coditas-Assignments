package week6.Day22.Assignments;

import java.util.Comparator;

/**
 * @author Zulfa Attar
 */

class Employee{
    int employeeId;
    String employeeName, employeeCity;

    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeCity='" + employeeCity + '\'' +
                '}';
    }
}

class SortByID implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.employeeId - o2.employeeId;
    }
}

class SortByName implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.employeeName.compareTo(o2.employeeName);
    }
}

class SortByCity implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.employeeCity.compareTo(o2.employeeCity);
    }
}
