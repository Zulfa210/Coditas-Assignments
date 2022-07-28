package week2.day8.practicals;
//rule 1: if you are declaring any method in normal class, you have to declare it as an abstract method
//rule 2: if any class contains abstract method, that class needs to be declared as an abstract class
//rule 3: in any abstract class you can add n("0..n") no. of abstract as well as concrete methods
//rule 4: if we extend abstract class, it is child class' responsibility to implement abstract methods
//rule 5: you cannot create an object of abstract class

abstract class Shape{
    public abstract void area();

    public void display(){
        System.out.println("This is Shape class");
    }
}

class Circle extends Shape{

    @Override
    public void area() {

    }
}

public class Abstraction_class_MainApplication {

}
