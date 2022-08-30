package week7.Day26.Assignments.Question1;

import java.util.Scanner;

/**
 * @author Zulfa Attar
 */


public class EmloyeeDriverClass {
    Scanner scanner = new Scanner(System.in);
    void addEmployee() {
        System.out.println("Enter the number of Employees you want to add: ");
        int noOfEmployees = scanner.nextInt();

        for (int i = 0; i < noOfEmployees; i++) {

            System.out.println("Enter Employee id: ");
            int id = scanner.nextInt();
            System.out.println("Enter Employee name: ");
            String name = scanner.next();
            System.out.println("Enter Employee designation: ");
            String designation = scanner.next();
            System.out.println("Enter Employee Date of joining in (yyyy-mm-dd) format: ");
            String doj = scanner.next();
            System.out.println("Enter Employee experience: ");
            int experience = scanner.nextInt();
            System.out.println("Enter Employee salary: ");
            float salary = scanner.nextFloat();
            System.out.println("Enter Employee status: ");
            String status = scanner.next();
            Employee employee = new Employee(id, name, designation, doj, experience, salary, status);

            new EmployeeOperations().addRecords(employee);
        }
    }
    public static void main(String[] args) {

        //case 1:
        //new EmployeeDriverClass().addEmployee();
        EmployeeOperations employeeOperations = new EmployeeOperations();
        //case 2:
        employeeOperations.showRecords();

        //case 3:
//        System.out.println("After altering table: ");
//        employeeOperations.alterTable();

        //case 4:
        System.out.println("Employee from pune whose salary is greater than 30000");
        employeeOperations.case4ShowEmployee();

        //case 5:
//        employeeOperations.updateSalary();

        //case 6:
//        employeeOperations.deleteEmployeesWhoLeft();

    }
}

/*
Output:
Case 1 output:
Enter the number of Employees you want to add:
2
Enter Employee id:
19
Enter Employee name:
Adi
Enter Employee designation:
Manager
Enter Employee Date of joining in (yyyy-mm-dd) format:
2021-11-28
Enter Employee experience:
10
Enter Employee salary:
95000
Enter Employee status:
working
Enter Employee id:
20
Enter Employee name:
Shubh
Enter Employee designation:
Tester
Enter Employee Date of joining in (yyyy-mm-dd) format:
2018-10-29
Enter Employee experience:
2
Enter Employee salary:
88000
Enter Employee status:
left

Case 2 output:

ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS
11        Zulfa               Developer           2021-08-22          4              20110.0             working
12        Zaid                Tester              2022-03-12          2              53000.0             working
13        Anuj                Manager             2022-07-11          2              47000.0             working
1         Ram                 Developer           2007-12-11          14             99000.0             left
15        Priya               Engineer            2019-11-23          9              81000.0             working
16        Dev                 Developer           2022-11-11          5              75000.0             left
17        Ayush               Director            2010-11-23          10             110999.0            working
18        Abhi                Developer           2012-11-04          1              67000.0             working
19        Adi                 Manager             2021-11-28          10             95000.0             working
20        Shubh               Tester              2018-10-29          2              88000.0             left

Case 3 Output:
After altering table:
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS              CITY
11        Zulfa               Developer           2021-08-22          4              20110.0             working             Pune
12        Zaid                Tester              2022-03-12          2              53000.0             working             Mumbai
13        Anuj                Manager             2022-07-11          2              47000.0             working             Nagpur
1         Ram                 Developer           2007-12-11          14             99000.0             left                Dehradun
15        Priya               Engineer            2019-11-23          9              81000.0             working             Kolkata
16        Dev                 Developer           2022-11-11          5              75000.0             left                Pune
17        Ayush               Director            2010-11-23          10             110999.0            working             Delhi
18        Abhi                Developer           2012-11-04          1              67000.0             working             Mumbai
19        Adi                 Manager             2021-11-28          10             95000.0             working             Kanpur
20        Shubh               Tester              2018-10-29          2              88000.0             left                Pune

Case 4 Output:
Employee from pune whose salary is greater than 30000
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS              CITY
16        Dev                 Developer           2022-11-11          5              75000.0             left                Pune
20        Shubh               Tester              2018-10-29          2              88000.0             left                Pune


Case 5 Output:
Before Updation:
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS
11        Zulfa               Developer           2021-08-22          4              20110.0             working
12        Zaid                Tester              2022-03-12          2              53000.0             working
13        Anuj                Manager             2022-07-11          2              47000.0             working
1         Ram                 Developer           2007-12-11          14             99000.0             left
15        Priya               Engineer            2019-11-23          9              81000.0             working
16        Dev                 Developer           2022-11-11          5              75000.0             left
17        Ayush               Director            2010-11-23          10             110999.0            working
18        Abhi                Developer           2012-11-04          1              67000.0             working
19        Adi                 Manager             2021-11-28          10             95000.0             working
20        Shubh               Tester              2018-10-29          2              88000.0             left

After Updation:
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS
11        Zulfa               Developer           2021-08-22          4              21110.0             working
12        Zaid                Tester              2022-03-12          2              53000.0             working
13        Anuj                Manager             2022-07-11          2              47000.0             working
1         Ram                 Developer           2007-12-11          14             100000.0            left
15        Priya               Engineer            2019-11-23          9              82000.0             working
16        Dev                 Developer           2022-11-11          5              76000.0             left
17        Ayush               Director            2010-11-23          10             111999.0            working
18        Abhi                Developer           2012-11-04          1              67000.0             working
19        Adi                 Manager             2021-11-28          10             96000.0             working
20        Shubh               Tester              2018-10-29          2              88000.0             left


Case 6 Output:
Before Updation:
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS
11        Zulfa               Developer           2021-08-22          4              21110.0             working
12        Zaid                Tester              2022-03-12          2              53000.0             working
13        Anuj                Manager             2022-07-11          2              47000.0             working
1         Ram                 Developer           2007-12-11          14             100000.0            left
15        Priya               Engineer            2019-11-23          9              82000.0             working
16        Dev                 Developer           2022-11-11          5              76000.0             left
17        Ayush               Director            2010-11-23          10             111999.0            working
18        Abhi                Developer           2012-11-04          1              67000.0             working
19        Adi                 Manager             2021-11-28          10             96000.0             working
20        Shubh               Tester              2018-10-29          2              88000.0             left

After Updation:
ID        NAME                DESIGNATION         DOJ                 EXPERIENCE     SALARY              STATUS
11        Zulfa               Developer           2021-08-22          4              21110.0             working
12        Zaid                Tester              2022-03-12          2              53000.0             working
13        Anuj                Manager             2022-07-11          2              47000.0             working
15        Priya               Engineer            2019-11-23          9              82000.0             working
17        Ayush               Director            2010-11-23          10             111999.0            working
18        Abhi                Developer           2012-11-04          1              67000.0             working
19        Adi                 Manager             2021-11-28          10             96000.0             working

Process finished with exit code 0

 */