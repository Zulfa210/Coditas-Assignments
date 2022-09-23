package com.bean;

import com.dao.DaoOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        try {
            Employee employee;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            DaoOperations daoOperations = context.getBean("employee", DaoOperations.class);
            int choice;
            do {
                employee = new Employee();
                System.out.println("1. Create Table \n2. Insert Employee \n3. Show All Employees\n4. Show one Employee" +
                        "\n5. Update Employee\n6. Delete employee\n7. Sort By Firstname\n8.Sort By Last Name\n" +
                        "9. Salary greater than 10000 aand city Mumbai\n Enter your choice: ");
                choice = Integer.parseInt(bufferedReader.readLine());

                switch (choice){
                    case 0:
                        System.exit(0);
                    case 1:
                        daoOperations.createTable();
                    case  2:
                        System.out.println("Enter Employee First name: ");
                        String employeeFirstName = bufferedReader.readLine();
                        System.out.println("Enter Employee Last Name: ");
                        String employeeLastName = bufferedReader.readLine();
                        System.out.println("Enter Employee salary: ");
                        float employeeSalary = Float.parseFloat(bufferedReader.readLine());
                        System.out.println("Enter Employee Address:\nEnter Address id, flat no., house name, city, pincode: ");
                        int employeeAddressId = Integer.parseInt(bufferedReader.readLine());
                        int employeeAddressFlatno = Integer.parseInt(bufferedReader.readLine());
                        String employeeAddressHouseName = bufferedReader.readLine();
                        String employeeAddressCity = bufferedReader.readLine();
                        int employeeAddressPincode = Integer.parseInt(bufferedReader.readLine());

                        employee.setEmployeeFirstName(employeeFirstName);
                        employee.setEmployeeLastName(employeeLastName);
                        employee.setEmployeeSalary(employeeSalary);
                        Address address = new Address();
                        address.setAddressId(employeeAddressId);
                        address.setFlatNo(employeeAddressFlatno);
                        address.setHouseName(employeeAddressHouseName);
                        address.setCity(employeeAddressCity);
                        address.setPinCode(employeeAddressPincode);

                        employee.setEmployeeAddress(address);
                        int check = daoOperations.insertEmployee(employee);
                        if(check> 0)
                            System.out.println("Added Successfully");
                        else
                            System.out.println("Error");
                        break;

                    case 3:
                        daoOperations.showAllEmployee();
                        break;
                    case 4:
                        System.out.println("Enter employee id: ");
                        int id = Integer.parseInt(bufferedReader.readLine());
                        daoOperations.showOneEmployee(id);
                        break;
                    case 5:
                        daoOperations.updateEmployee();
                        daoOperations.showAllEmployee();
                        break;
                    case 6:
                        System.out.println("Enter employee id: ");
                        int employeeId1= Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Enter address id: ");
                        int addressID1= Integer.parseInt(bufferedReader.readLine());

                        daoOperations.deleteEmployee(employeeId1,addressID1);
                        break;

                    case 7:
                        daoOperations.sortByFirstName();
                        break;
                    case 8:
                        daoOperations.sortByLastName();
                        break;

                    case 9:
                        daoOperations.showSalaryAndMumbai();
                    default:
                        System.out.println("Incorrect choice");
                }

            } while (choice != 0);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
