package week4.Day16.Assignments.Q2_InputWays;

public class CLI_Input {
    public void acceptDetails(String name, int id, float salary){
        Employee employee = new Employee(id, name, salary);
        new CLI_Input().displayDetails(employee);
    }
    public void displayDetails(Employee employee){
        System.out.println("=========Employee Details by CLA=============");
        System.out.println("Employee Name: " + employee.name + "\nEmployee id: " +  employee.eid + "\nSalary: " + employee.esal);

    }

    public static void main(String[] args) {
        String name = args[0];
        int id = Integer.parseInt(args[1]);
        float salary = Float.parseFloat(args[2]);
        new CLI_Input().acceptDetails(name, id, salary);

    }
}

/*
output:
=========Employee Details by CLA=============
Employee Name: Zulfa
Employee id: 112
Salary: 8000.0

Process finished with exit code 0
 */