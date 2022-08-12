package week4.Day16;

//import week4.Day16.Assignments.Q2_InputWays.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


class Employee implements Serializable {
    int eid;
    String name;
    float esal;

    public Employee(int eid, String name, float esal) {
        this.eid = eid;
        this.name = name;
        this.esal = esal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\neid=" + eid +
                "\nname='" + name +
                "\nesal=" + esal +
                '}';
    }
}

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
