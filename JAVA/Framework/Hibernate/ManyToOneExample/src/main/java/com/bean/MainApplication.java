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
        try{
            User user = new User();
            System.out.println("Enter user name, user city: ");
            user.setUserName(bufferedReader.readLine());
            user.setUserCity(bufferedReader.readLine());

            Vehicle vehicle;
            System.out.println("Enter no. of Vehicles: ");
            List<Vehicle> vehicleList = new ArrayList<>();
            int noOfVehicles = Integer.parseInt(bufferedReader.readLine());
            for(int i =0; i<noOfVehicles; i++){
                vehicle = new Vehicle();
                System.out.println("Enter vehicle Name");
                vehicle.setVehicleName(bufferedReader.readLine());
                vehicle.setUserDetails(user);
                vehicleList.add(vehicle);
            }
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            Session session = configuration.buildSessionFactory().openSession();

            Transaction transaction = session.beginTransaction();

            int check = (int) session.save(user);
            for(Vehicle v:vehicleList){
                check += (int)session.save(v);
            }

            if(check>0){
                transaction.commit();
                System.out.println("Records Added Successfuly");
            }else {
                System.out.println("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
