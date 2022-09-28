package com.bean;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            Session session = configuration.buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();

            System.out.println("Enter student name and class:");
            Student student = new Student();
            student.setStudentName(bufferedReader.readLine());
            student.setStudentClass(bufferedReader.readLine());
            List<Address> addressList = new ArrayList<>();
            int ch;
            Address address;
            System.out.println("Enter no. of Addresses");
            ch = Integer.parseInt(bufferedReader.readLine());
            for(int i =0; i<ch; i++){
                address = new Address();
                System.out.println("Enter Flat no., Street name, City");
                address.setAddressFlatNo(bufferedReader.readLine());
                address.setAddressStreetName(bufferedReader.readLine());
                address.setAddressCity(bufferedReader.readLine());
                address.setStudent(student);

                addressList.add(address);


            }
            student.setStudentAddress(addressList);

            int i = (int)session.save(student);
            for (Address address1: addressList){
                i += (int)session.save(address1);
            }
            if(i>0){
                transaction.commit();
                System.out.println("Added Successfully");
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
