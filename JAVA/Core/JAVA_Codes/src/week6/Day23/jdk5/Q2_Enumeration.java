package week6.Day23.jdk5;

import week2.day9.Ques5_DriverClass;

/**
 * @author Zulfa Attar
 */

//2)Write a program using enum which will print following output
//Add enum RED("STOP"),GREEN("GO"),YELLOW("DRIVE VERY SLOW")
//Try to print values
//RED MEANS STOP
//GREEN MEANS GO
//YELLOW MEANS DRIVE VERY SLOw
//
enum Signal{
    RED("STOP"),
    GREEN("GO"),
    YELLOW("DRIVE VERY SLOWLY");

    private String data;
    Signal(String message) {
        this.data = message;
    }

    //method to get the message
    public String getData(){
        return data;
    }

}
public class Q2_Enumeration {
    void displayEnum(){
        for(Signal colour: Signal.values())
            System.out.println(colour.name() + " means " + colour.getData());
    }
    public static void main(String[] args) {

        Q2_Enumeration object = new Q2_Enumeration();
        object.displayEnum();
    }
}

/*Output
RED means STOP
GREEN means GO
YELLOW means DRIVE VERY SLOWLY

Process finished with exit code 0

 */