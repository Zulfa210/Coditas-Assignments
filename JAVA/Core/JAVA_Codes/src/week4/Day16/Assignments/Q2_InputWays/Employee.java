package week4.Day16.Assignments.Q2_InputWays;

import java.io.Serializable;

public class Employee implements Serializable {
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
                "\nname='" + name  +
                "\nesal=" + esal +
                '}';
    }
}
