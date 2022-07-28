package week2.day8.practicals;
//Rule 1 = by default interface methods are abstract and public
//Rule 2 = by default interface variables are public, static, final
    //Q) Can any interface contain concrete ()?
    //yes, if it is static/ default  => it is an enhancement from JDK 1.8
//Rule 3 => Interface uses "implements" keyword
//Rule 4 => you can implement as many interface as you want, just by giving ","
//Rule 5 => once you implement any interface you have to implement all its abstract methods
    //so, this is an AGREEMENT between interface and class which is implementing it.
//Rule 6 => you cannot create an object of interface

public interface ShapeNew {
    void area();

    static void display(){
    }
    default void draw(){
    }
}

class Rectangle implements ShapeNew{


    @Override
    public void area() {

    }

    @Override
    public void draw() {
        //ShapeNew.super.draw();
    }
}
