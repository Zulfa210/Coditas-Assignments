package week4.Day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {
    public static void main(String[] args) {
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("EmpSerialNew.txt"));

            Employee obj1 = (Employee) obj.readObject();
            System.out.println("Deserialization done successfully");
            System.out.println("Employee id: " + obj1.eid + "\nEmployee name: " + obj1.name + "\nSalary: " + obj1.esal);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
