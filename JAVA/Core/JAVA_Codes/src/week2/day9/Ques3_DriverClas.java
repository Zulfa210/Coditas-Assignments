package week2.day9;
//4)Practically prove, After changing the return type, overriding happens or not?

//
//From Java 5 onwards, we can override a method by changing its return
//type only by abiding the condition that return type is a subclass of that of overridden method return type.
//covariant return type is used in this type

class Vehicle {
    Vehicle get() {
        System.out.println("This is Vehicle class");
        return this;
    }
}

class Car extends Vehicle {
    Car get() {
        System.out.println("This is a Car");
        return this;
    }


}
public class Ques3_DriverClas {
    public static void main(String[] args) {
        Vehicle cars;
        cars = new Car();
        cars.get();

        cars =  new Vehicle();
        cars.get();
    }
}
//output
//This is a Car
//This is Vehicle class