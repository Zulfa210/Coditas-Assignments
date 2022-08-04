package week3.day12.Assignment;

//Q.8 )Using Constructor try to Reinitialize values of class Employee(emp_id,emp_name,emp_address.emp_sal)
class Employee{

    int emp_id;
    String emp_name;
    String emp_address;
    float emp_sal;

    public Employee(int emp_id, String emp_name, String emp_address, float emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.emp_sal = emp_sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_address='" + emp_address + '\'' +
                ", emp_sal=" + emp_sal +
                '}';
    }
}

public class Ques8_Constructor {
    public static void main(String[] args) {
        Employee zulfa  = new Employee(11, "Zulfa", "Pune", 10000f);
        System.out.println(zulfa.toString());
    }
}

//output:
//Employee{emp_id=11, emp_name='Zulfa', emp_address='Pune', emp_sal=10000.0}
//
//Process finished with exit code 0