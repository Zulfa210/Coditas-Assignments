package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class MainApplication {

    public void menu(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            Configuration configuration = new Configuration();

            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            int choice;
            do{
                System.out.println("0. Exit \n1. Add Employee " +
                        "\n2.Print total no. records" +
                        "\n3. Print total sum of employee salaries" +
                        "\n4. Show employee from particular City" +
                        "\n5. Employees having 'ti' in their name" +
                        "\n6. Update salary by 5000 whose salary is greater than 20000" +
                        "\nEnter your choice");
                choice = Integer.parseInt(bufferedReader.readLine());

                switch (choice){
                    case 1:
                        System.out.println("Enter Employee name, designation, salary, city: ");
                        Employee employee = new Employee();

                        employee.setEmployeeName(bufferedReader.readLine());
                        employee.setEmployeeDesignation(bufferedReader.readLine());
                        employee.setEmployeeSalary(Float.parseFloat(bufferedReader.readLine()));
                        employee.setEmployeeCity(bufferedReader.readLine());

                        int success = (int) session.save(employee);

                        if (success != 0){
                            System.out.println("Added Successfully");
                            transaction.commit();
                        }else {
                            System.out.println("Error");
                            transaction.rollback();
                        }
                        break;

                    case 2:
                        List<Employee> employeeList = session.createQuery("from Employee").list();
                        System.out.println("Total no. Employees added: " + employeeList.size());
                        break;

                    case 3:
                        List<Employee> employeeListnew = session.createQuery("from Employee").list();
                        float sumOfSalaries = 0;
                        for(Employee employee1: employeeListnew){
                            sumOfSalaries+= employee1.getEmployeeSalary();
                        }
                        System.out.println(sumOfSalaries);
                        break;

                    case 4:
                        System.out.println("Enter city: ");
                        String city = bufferedReader.readLine();
                        String hqlQuery = "from Employee e where e.employeeCity='" + city + "'";
                        Query query = session.createQuery(hqlQuery);
                        List<Employee> cityEmployee = query.list();
                        for(Employee employee1: cityEmployee){
                            System.out.println(employee1);
                        }
                        break;

                    case 5:
                        String str = "ti";
                        String hqlQuery1 = "from Employee e where e.employee_name like :name";
                        Query query1 = session.createQuery(hqlQuery1).setParameter("name","%" + str + "%");
                        List<Employee> tiEmployee = query1.list();
                        for(Employee employee1: tiEmployee){
                            System.out.println(employee1);
                        }
                        break;

                    case 6:
                        Query query2 = session.createQuery("update Employee set employee_salary = employee_salary + 5000 where employee_salary>20000");
                        List<Employee> list = query2.list();

                        for (Employee employee1: list){
                            System.out.println(employee1);
                        }

                }
            }while (choice!=0);



            List<Employee> employeeList = session.createQuery("from Employee").list();

            for (Employee e: employeeList){
                System.out.println(e);
            }



        }catch (Exception e){

        }

    }
    public static void main(String[] args) {
        new MainApplication().menu();
    }

}

/*
Output:
Hibernate: create table Employee_table (employeeId integer not null, employee_designation varchar(255), employee_name varchar(255), employee_salary float, primary key (employeeId)) engine=MyISAM

Hibernate: select next_val as id_val from hibernate_sequence for update
Hibernate: update hibernate_sequence set next_val= ? where next_val=?
Added Successfully
Hibernate: insert into Employee_table (employee_designation, employee_name, employee_salary, employeeId) values (?, ?, ?, ?)

Process finished with exit code 0
 */