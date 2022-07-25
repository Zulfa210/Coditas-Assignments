package week1.day4.Assignments;

class cars{
    public static void displayCar(){
        System.out.println("This is in Car class");
    }
}
class BMW extends cars{
    public static void displayCar(){
        System.out.println("This is in BMW class");
    }
}
public class Q3_2_Static_Override_Java {

    public static void main(String[] args) {
        cars object  = new BMW();

        object.displayCar();
        //although we are giving reference of child class, but the static method from parent class is called.
        //Hence, we cannot override static method

    }
}

//output:
//This is in Car class