package week2.day8.Assignments;
//1)Write a program in which you will declare an abstract class Vehicle inherits this class from two
// classes car and truck using the method engine in both display "car has good engine" and "truck has bad engine".

abstract class Vehicle{
    abstract void engine();
}

class Car extends Vehicle{

    @Override
    void engine() {
        System.out.println("Car Engine has Good engine");

    }
}
class Truck extends Vehicle{

    @Override
    void engine() {
        System.out.println("Truck Engine has bad engine ");
    }
}

public class Q1_DriverClass {

    public static void main(String[] args) {
        Vehicle car = new Car();
        car.engine();

        Vehicle truck  = new Truck();
        truck.engine();
    }
}

//output
//Car Engine has Good engine
//Truck Engine has bad engine
//
//Process finished with exit code 0