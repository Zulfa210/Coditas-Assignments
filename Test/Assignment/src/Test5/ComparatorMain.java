package Test5;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Zulfa Attar
 */

class Employee{
    int employeeId;
    String employeeName;
    float employeeSalary;
    String employeeCity;
    int employeePincode;
    int employeeExperience;

    public Employee(int employeeId, String employeeName, float employeeSalary, String employeeCity, int employeePincode, int employeeExperience) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeCity = employeeCity;
        this.employeePincode = employeePincode;
        this.employeeExperience = employeeExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeCity='" + employeeCity + '\'' +
                ", employeePincode=" + employeePincode +
                ", employeeExperience=" + employeeExperience +
                '}';
    }
}

class SortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.employeeName.compareTo(o2.employeeName);
    }


}

class SortBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.employeeSalary- o2.employeeSalary);
    }


}

class SortByCity implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.employeeCity.compareTo(o2.employeeCity);
    }

}


public class ComparatorMain {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(11, "Zulfa", 20000f, "Pune",411006, 5));
        employeeList.add(new Employee(16, "Zaid", 50000f, "Pune",411006, 5));
        employeeList.add(new Employee(12, "Abhishek", 2000f, "Mumbai",411006, 5));
        employeeList.add(new Employee(13, "Devansh", 40000f, "Kolkata",411006, 5));
        employeeList.add(new Employee(14, "Priya", 60000f, "Banglore",411006, 5));

        System.out.println("===========Before Sorting==========");
        Iterator iterator = employeeList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        System.out.println("===========Sorting by NAme==========\n");


        Collections.sort(employeeList,new SortByName());
        Iterator iterator2 = employeeList.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println("\n===========Sorting By Salary==========\n");

        Collections.sort(employeeList,new SortBySalary());
         iterator = employeeList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n===========Sorting by city==========\n");

        Collections.sort(employeeList,new SortByCity());
         iterator = employeeList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n==========Employee whose city is Pune and salary greater that 10000===========\n");

        List list = employeeList.stream()
                        .filter(i->i.employeeCity=="Pune" && i.employeeSalary>10000)
                        .collect(Collectors.toList());
        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n=================Name Length greater than 5======================\n");

        List list1 = employeeList.stream().filter(i -> i.employeeName.length()>5)
                        .collect(Collectors.toList());
        iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
