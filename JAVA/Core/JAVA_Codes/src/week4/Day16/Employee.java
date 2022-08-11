package week4.Day16;

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

}
