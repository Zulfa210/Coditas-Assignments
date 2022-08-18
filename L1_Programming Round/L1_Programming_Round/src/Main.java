import java.util.Scanner;

/**
 * @author Zulfa Attar
 */

class Employee {
    int employee_id;
    String employee_name;
    String employee_Address;
    String Designation;
    int experience;

//    public Employee(int employee_id, String employee_name,
//                    String employee_Address, String designation, int experience) {
//        this.employee_id = employee_id;
//        this.employee_name = employee_name;
//        this.employee_Address = employee_Address;
//        Designation = designation;
//        this.experience = experience;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_Address='" + employee_Address + '\'' +
                ", Designation='" + Designation + '\'' +
                ", experience=" + experience +
                '}';
    }

    void acceptDetails(int employee_id) {
        try {
            Scanner scanner = new Scanner(System.in);

                if(employee_id <1000 || employee_id>2000){
                    throw new InvalidEmployeeIDException("Invalid Employee ID");
                }

            System.out.println("Enter employee name");
            String employee_name = scanner.next();
            System.out.println("Enter employee address");
            String employee_address = scanner.next();
            System.out.println("Enter employee designation");
            String employee_designation = scanner.next();
            System.out.println("Enter employee experience");
            int employee_experience = scanner.nextInt();


            this.employee_id = employee_id;
            this.employee_name = employee_name;
            this.employee_Address = employee_Address;
            this.Designation = employee_designation;
            this.experience = experience;
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static Employee searchEmployee(Employee employee_id) {

        Employee employee = new Employee();

        return employee;
    }

}





class Manager extends Employee{

    String Department;

//    public Manager(int employee_id, String employee_name,
//                   String employee_Address, String designation, int experience, String Department) {
//        //super(employee_id, employee_name, employee_Address, designation, experience);
//        this.Department = Department;
//    }

    public Manager promoteEmployee(Employee employee1){

      Manager manager = new Manager();
        try {
            if (employee1.experience > 5) {
                Scanner scanner = new Scanner(System.in);
                String Department = scanner.next();
                manager.employee_id = employee1.employee_id;
                manager.employee_name = employee1.employee_name;
                manager.employee_Address = employee1.employee_Address;
                manager.Designation = "Manager";
                manager.experience = employee1.experience;
                manager.Department = Department;
            } else {
                throw new InvalidExperienceException("Invalid Experience");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return manager;
    }



}

public class Main {
    public void displayEmployees(Employee[] employee, int x){
        for(int i =0 ; i<x; i++){
            System.out.println(employee[x].toString());
        }

    }
    public void displayManager(Manager[] manager, int k){
        for(int i =0 ; i<k; i++){
            System.out.println(manager[k].toString());
        }

    }

    int checkEmployeeID(Employee[] employee, int employee_id, int noOfEmployees){
        try {
            for (int j = 0; j < noOfEmployees; j++) {
                if (employee[j].employee_id == employee_id) {
                    throw new DuplicateEmployeeDetailsException("Invalid Employee ID");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }



    public static void main(String[] args) {

        Main main = new Main();
        Employee employee[] = new Employee[10];
        Manager manager[] = new Manager[10];
        int i = 0, k =0;
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter no. of Employees");
//        int n = scanner.nextInt();

        int choice;
        do{
            System.out.println("Enter your choice: \n0: Exit \n1: Add an employee" +
                    "\n2: Show All Employees\n3: Promote Employee to Manager\n4: Show All Managers");
            choice  = scanner.nextInt();

            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                        Employee employee1 = new Employee();
                        System.out.println("Enter Employee id: ");
                        int employee_id2 = scanner.nextInt();

                        if(i>0) {
                            int correct = main.checkEmployeeID(employee, employee_id2, i);

                            if (correct == 1) {
                                employee1.acceptDetails(employee_id2);
                                employee[i++] = employee1;
                            }
                        }
                        else {
                            employee1.acceptDetails(employee_id2);
                            employee[i++] = employee1;
                        }


                    break;
                case 2:
                    main.displayEmployees(employee, i);
                    break;

                case 3:
                    System.out.println("Enter Employee id: ");
                    int employee_id1 = scanner.nextInt();

                    for(int j = 0; j<employee.length; j++){
                        if(employee[j].employee_id == employee_id1 ){
                            Manager manager1 = new Manager();
                            manager1 = manager1.promoteEmployee(employee[j]);
                            manager[k++] = manager1;
                        }
                    }
                    break;

                case 4:
                    main.displayManager(manager,k);



            }
        }while (choice !=0);
    }
}