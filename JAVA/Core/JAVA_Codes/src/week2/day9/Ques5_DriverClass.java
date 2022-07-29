package week2.day9;

//5)Write a program using enum which will print following output
//Add enum RED('STOP"),GREEN("GO"),YELLOw"DRIVE VERY SLOW")
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
public class Ques5_DriverClass {

    void displayEnum(){
        for(Signal colour: Signal.values())
            System.out.println(colour.name() + " stands for " + colour.getData());
    }
    public static void main(String[] args) {

        Ques5_DriverClass object = new Ques5_DriverClass();
        object.displayEnum();
    }
}
//output:
//RED stands for STOP
//GREEN stands for GO
//YELLOW stands for DRIVE VERY SLOWLY
