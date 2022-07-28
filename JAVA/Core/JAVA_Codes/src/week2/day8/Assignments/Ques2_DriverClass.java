package week2.day8.Assignments;
import java.util.*;

//2)Create an abstract class Instrument which has the abstract function play. Create three more
// subclasses from Instrument which are Piano, Flute, Guitar. Override the play method inside all
// three classes printing a message.
// "Piano is playing tan tan tan tan" for Piano class "Flute is playing toot toot toot toot"
// for Flute class "Guitar is playing tin tin tin" for Guitar class
//You must not allow the user to declare an object of Instrument class. Create an array of 10 Instruments. Assign different types of instrument to Instrument reference. Check for the polymorphic behavior of the play method. Use the instanceof operator to print which object stored at which index of instrument array.

abstract class Instrument{
    abstract void play();
}

class Piano extends Instrument{

    @Override
    void play(){
        System.out.println("Piano is playing tan tan tan tan");
    }
}
class Flute extends Instrument{

    @Override
    void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}

class Guitar extends Instrument{

    @Override
    void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}

public class Ques2_DriverClass {

    public void displayInstance(Instrument instrument[]){

        for(int i = 0; i < instrument.length; i++){
            if(instrument[i] instanceof Piano){
                System.out.println("------------------------------------------");
                System.out.println("Object " + (i+1) + " is an object of Piano. ");
                instrument[i].play();
            }
            if(instrument[i] instanceof Flute){
                System.out.println("------------------------------------------");
                System.out.println("Object " + (i+1) + " is an object of Flute. ");
                instrument[i].play();
            }
            if(instrument[i] instanceof Guitar){
                System.out.println("------------------------------------------");
                System.out.println("Object " + (i+1) + " is an object of Guitar. ");
                instrument[i].play();
            }

        }

    }

    public static void main(String[] args) {

        Instrument instruments[] = new Instrument[10];
        Random randomVariable = new Random();

        for(int i = 0; i < 10; i++){
            int type = randomVariable.nextInt(3);

            switch (type){
                case 0:
                    instruments[i] = new Piano();
                    break;

                case 1:
                    instruments[i] = new Flute();
                    break;

                case 2:
                    instruments[i] = new Guitar();
                    break;
            }
        }
        new Ques2_DriverClass().displayInstance(instruments);

    }
}
//ouput:
//------------------------------------------
//Object 1 is an object of Guitar.
//Guitar is playing tin tin tin
//------------------------------------------
//Object 2 is an object of Piano.
//Piano is playing tan tan tan tan
//------------------------------------------
//Object 3 is an object of Piano.
//Piano is playing tan tan tan tan
//------------------------------------------
//Object 4 is an object of Flute.
//Flute is playing toot toot toot toot
//------------------------------------------
//Object 5 is an object of Piano.
//Piano is playing tan tan tan tan
//------------------------------------------
//Object 6 is an object of Flute.
//Flute is playing toot toot toot toot
//------------------------------------------
//Object 7 is an object of Piano.
//Piano is playing tan tan tan tan
//------------------------------------------
//Object 8 is an object of Piano.
//Piano is playing tan tan tan tan
//------------------------------------------
//Object 9 is an object of Flute.
//Flute is playing toot toot toot toot
//------------------------------------------
//Object 10 is an object of Piano.
//Piano is playing tan tan tan tan
//
//Process finished with exit code 0