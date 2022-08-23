package week6.Day22;

import java.util.*;

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

class SortByID implements Comparator<Employee>{

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
public class ComparatorDemo {


    public static void main(String[] args) {
       // Employee employee =new Employee(5, "Z", "Pune");
        ArrayList<Employee> arrayList= new ArrayList<Employee>();
        arrayList.add(new Employee(5, "Z", "Pune"));
        arrayList.add(new Employee(6, "A", "Mumbai"));
        arrayList.add(new Employee(2, "D", "Satara"));
        arrayList.add(new Employee(1, "C", "Sangli"));
        arrayList.add(new Employee(3, "B", "Kolkata"));

        System.out.println("***************BEFORE SORTING************************");
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("***************AFTER SORTING BY ID************************");
       // ArrayList<Employee> arrayList1 = arrayList;;
        Collections.sort(arrayList, new SortByID());
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("***************AFTER SORTING BY NAME************************");
        Collections.sort(arrayList, new SortByName());
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("***************AFTER SORTING BY CITY************************");
        Collections.sort(arrayList, new SortByCity());
        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        HashMap<Integer, Employee> hashMap = new HashMap<>();



    }

}
