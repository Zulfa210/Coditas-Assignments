package week6.Day24;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zulfa Attar
 */
class Employee{
    private String name;
    private double Salary;
    private int ID;

    private List<String> projects;

    public Employee(int ID,String name, double salary,  List<String> projects) {
        this.name = name;
        Salary = salary;
        this.ID = ID;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProjects() {
        return projects;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Salary=" + Salary +
                ", ID=" + ID +
                '}';
    }


}
public class StreamApiDemo {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(11, "Zulfa", 20000, Arrays.asList("Project1", "Project2", "Project3")));
        employeeList.add(new Employee(12, "Zaid", 50000, Arrays.asList("Project1", "Project2", "Project3")));
        employeeList.add(new Employee(13, "Ram", 60000, Arrays.asList("Project1", "Project2", "Project3")));
        employeeList.add(new Employee(14, "Priya", 80000, Arrays.asList("Project1", "Project2", "Project3")));

        employeeList.stream()
                .forEach(employee -> System.out.println(employee));

        //using map
        Set<Employee> list = employeeList.stream()
                .map(employee -> new Employee(
                        employee.getID(),
                        employee.getName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toSet());

        System.out.println("\nUpdated Salary");
        list.stream()
                .forEach(employee -> System.out.println(employee));

        //using filter
        List<Employee> list2 = employeeList.stream()
                .filter(employee -> employee.getSalary()>20000)
                .map(employee -> new Employee(
                        employee.getID(),
                        employee.getName(),
                        employee.getSalary(),
                        employee.getProjects()
                ))
                .collect(Collectors.toList());


        System.out.println("\nSalary Greater than 20000");
        list2.stream()
                .forEach(employee -> System.out.println(employee));

        //using find first
        Employee firstEmployee = employeeList.stream()
                .filter(employee -> employee.getSalary()>30000)
                .map(employee -> new Employee(
                        employee.getID(),
                        employee.getName(),
                        employee.getSalary(),
                        employee.getProjects()
                ))
                .findFirst()
                .orElse(null);

        System.out.println("\nFirst Employee "  + firstEmployee);


        //flatmap
        String Projects = employeeList.stream()
                .map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println("\nCreating Float Map");
        System.out.println("Projects: " + Projects);


        //short circuit operations
        List<Employee> shortCircuit = employeeList
                .stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());

        System.out.println("\nShort Circuiting Operaions:" + shortCircuit + '\n');

        //finite data
        System.out.println("Random Numbers");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        List<Employee> sortedEmployeeByName =
                employeeList.stream()
                        .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                        .collect(Collectors.toList());
        System.out.println("\nSorted Employee by name");
        sortedEmployeeByName.stream()
                .forEach(employee -> System.out.println(employee));

        List<Employee> sortedEmployeeBySalary =
                employeeList.stream()
                        .sorted(Comparator.comparing(Employee::getSalary))
                        .collect(Collectors.toList());
        System.out.println("\nSorted Employee by Salary");
        sortedEmployeeByName.stream()
                .forEach(employee -> System.out.println(employee));


        //min or max
        System.out.println("\n Maximum Salary: \n" +
                employeeList
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new)
        );

        //reduce
        System.out.println("\nSum of Salaries: \n" +
                employeeList
                        .stream()
                        .map(employee -> employee.getSalary())
                        .reduce(0.0,Double::sum)
                );


    }
}

/*
Output:
Employee{name='Zulfa', Salary=20000.0, ID=11}
Employee{name='Zaid', Salary=50000.0, ID=12}
Employee{name='Ram', Salary=60000.0, ID=13}
Employee{name='Priya', Salary=80000.0, ID=14}

Updated Salary
Employee{name='Priya', Salary=88000.0, ID=14}
Employee{name='Zaid', Salary=55000.00000000001, ID=12}
Employee{name='Zulfa', Salary=22000.0, ID=11}
Employee{name='Ram', Salary=66000.0, ID=13}

Salary Greater than 20000
Employee{name='Zaid', Salary=50000.0, ID=12}
Employee{name='Ram', Salary=60000.0, ID=13}
Employee{name='Priya', Salary=80000.0, ID=14}

First Employee Employee{name='Zaid', Salary=50000.0, ID=12}

Creating Float Map
Projects: Project1,Project2,Project3,Project1,Project2,Project3,Project1,Project2,Project3,Project1,Project2,Project3

Short Circuiting Operaions:[Employee{name='Zaid', Salary=50000.0, ID=12}]

Random Numbers
0.15676003689261997
0.734100885742414
0.22223357780652397
0.4023735510736649
0.8456906128616493

Sorted Employee by name
Employee{name='Priya', Salary=80000.0, ID=14}
Employee{name='Ram', Salary=60000.0, ID=13}
Employee{name='Zaid', Salary=50000.0, ID=12}
Employee{name='Zulfa', Salary=20000.0, ID=11}

Sorted Employee by Salary
Employee{name='Priya', Salary=80000.0, ID=14}
Employee{name='Ram', Salary=60000.0, ID=13}
Employee{name='Zaid', Salary=50000.0, ID=12}
Employee{name='Zulfa', Salary=20000.0, ID=11}

 Maximum Salary:
Employee{name='Priya', Salary=80000.0, ID=14}

Sum of Salaries:
210000.0

Process finished with exit code 0

 */