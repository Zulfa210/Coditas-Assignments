package week4.Day16;

import week4.Day16.Assignments.Q2_InputWays.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableDemo {
    public static void main(String[] args) {
        Employee obj = new Employee(111, "Zulfa", 50000f);

        try {
            FileOutputStream fout = new FileOutputStream("EmpSerialNew.txt");
            ObjectOutputStream obj_o = new ObjectOutputStream(fout);

            obj_o.writeObject(obj);
            System.out.println("Serialization Done");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
